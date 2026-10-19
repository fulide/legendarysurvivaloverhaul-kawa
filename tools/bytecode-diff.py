import re
import subprocess
import sys

OLD_CP, NEW_CP, CLS = sys.argv[1], sys.argv[2], sys.argv[3]


def dump(cp):
    out = subprocess.run(["javap", "-p", "-c", "-cp", cp, CLS],
                         capture_output=True, text=True, encoding="utf-8", errors="replace")
    return out.stdout.splitlines()


def parse(lines):
    methods = {}
    cur = None
    for line in lines:
        m = re.match(r"^  (?:public|private|protected|static|final|synchronized|native|abstract|default| )*.*?([\w<>$]+)\((.*?)\);$", line.strip())
        if line.startswith("  ") and not line.startswith("   ") and "(" in line and line.rstrip().endswith(";"):
            cur = line.strip()
            methods[cur] = []
            continue
        if cur is None:
            continue
        s = line.strip()
        if not s or s.startswith("Code:") or s.startswith("Compiled from"):
            continue
        s = re.sub(r"^\d+:\s*", "", s)            # offsets
        s = re.sub(r"#\d+", "#", s)               # constant pool indices
        s = re.sub(r"(?<=\s)\d+(?=\s*$)", "L", s)  # branch targets
        s = re.sub(r"\s+", " ", s).strip()
        methods[cur].append(s)
    return methods


a = parse(dump(OLD_CP))
b = parse(dump(NEW_CP))

print(f"methods old={len(a)} new={len(b)}")
print("missing in new:", sorted(set(a) - set(b))[:5])
print("added in new:", sorted(set(b) - set(a))[:5])

total = 0
for name in a:
    if name not in b:
        continue
    if a[name] != b[name]:
        total += 1
        diff = [line for line in a[name] if line not in b[name]]
        added = [line for line in b[name] if line not in a[name]]
        print(f"\n--- {name}  (old {len(a[name])} insns, new {len(b[name])} insns)")
        for line in diff[:12]:
            print("  -", line)
        for line in added[:12]:
            print("  +", line)
print(f"\nmethods differing: {total}")
