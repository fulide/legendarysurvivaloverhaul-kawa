import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LineNumberNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Removes statement-level {@code LegendarySurvivalOverhaul.LOGGER.info(...)} calls from a class,
 * byte-for-byte except for the removed instructions.  Used to delete the per-second limb-healing
 * log spam without recompiling the (decompiled) sources.
 */
public final class StripLoggerCalls
{
    private static final String LOGGER_OWNER = "sfiomn/legendarysurvivaloverhaul/LegendarySurvivalOverhaul";
    private static final String LOGGER_FIELD = "LOGGER";
    private static final String LOGGER_TYPE = "org/apache/logging/log4j/Logger";

    public static void main(String[] args) throws Exception
    {
        int total = 0;
        for (String arg : args)
        {
            Path path = Path.of(arg);
            byte[] original = Files.readAllBytes(path);
            ClassNode node = new ClassNode();
            new ClassReader(original).accept(node, 0);

            int removedHere = 0;
            for (MethodNode method : node.methods)
            {
                InsnList insns = method.instructions;
                AbstractInsnNode insn = insns.getFirst();
                while (insn != null)
                {
                    if (isLoggerGetStatic(insn))
                    {
                        List<AbstractInsnNode> range = collectRange(insn);
                        if (range == null)
                            throw new IllegalStateException("unsupported LOGGER statement in " + node.name + "." + method.name);
                        AbstractInsnNode after = range.get(range.size() - 1).getNext();
                        for (AbstractInsnNode n : range)
                            insns.remove(n);
                        removedHere++;
                        insn = after;
                        continue;
                    }
                    insn = insn.getNext();
                }
            }

            ClassWriter writer = new ClassWriter(0);
            node.accept(writer);
            Files.write(path, writer.toByteArray());
            System.out.println(path.getFileName() + ": removed " + removedHere + " log call(s)");
            total += removedHere;
        }
        System.out.println("total removed: " + total);
    }

    private static boolean isLoggerGetStatic(AbstractInsnNode insn)
    {
        if (!(insn instanceof FieldInsnNode field) || insn.getOpcode() != Opcodes.GETSTATIC)
            return false;
        return LOGGER_OWNER.equals(field.owner) && LOGGER_FIELD.equals(field.name);
    }

    /** Returns every instruction from the LOGGER GETSTATIC through the closing info(...) call. */
    private static List<AbstractInsnNode> collectRange(AbstractInsnNode start)
    {
        List<AbstractInsnNode> range = new ArrayList<>();
        range.add(start);
        AbstractInsnNode cur = start.getNext();
        while (cur != null)
        {
            if (cur instanceof JumpInsnNode)
                return null;                    // do not touch control flow
            if (cur instanceof MethodInsnNode call
                    && LOGGER_TYPE.equals(call.owner)
                    && call.name.equals("info"))
            {
                range.add(cur);
                return range;
            }
            // labels / line numbers / frames inside the arguments are kept in place
            if (!(cur instanceof LabelNode || cur instanceof LineNumberNode
                    || cur instanceof org.objectweb.asm.tree.FrameNode))
                range.add(cur);
            cur = cur.getNext();
        }
        return null;
    }
}
