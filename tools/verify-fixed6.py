import hashlib
import json
import struct
import sys
import zipfile

NEW, OLD = sys.argv[1], sys.argv[2]

PATCHED = {
    "sfiomn/legendarysurvivaloverhaul/common/attachments/bodydamage/BodyDamageAttachment.class",
    "sfiomn/legendarysurvivaloverhaul/client/screens/BodyPartButton.class",
    "sfiomn/legendarysurvivaloverhaul/client/screens/BodyPartButton$BodyPartCondition.class",
    "sfiomn/legendarysurvivaloverhaul/client/screens/BodyHealthScreen.class",
}
BANNED = [b"[ITEM HEALING]", b"[FIRST AID HEALING]", b"[PASSIVE REGEN HEALING]",
          b"[BodyPartButton]", b"[BodyPartCondition]", b"[drawHealthBar]"]

checks = []


def check(ok, label, detail=""):
    checks.append((bool(ok), label, detail))


with zipfile.ZipFile(NEW) as jar, zipfile.ZipFile(OLD) as old:
    names = set(jar.namelist())
    check(len(names) == 2919, "entry count 2919", str(len(names)))

    changed = [n for n in old.namelist() if old.read(n) != jar.read(n)]
    check(set(changed) == PATCHED, "exactly the 4 intended classes changed", ", ".join(sorted(set(changed) ^ PATCHED)))

    for name in PATCHED:
        data = jar.read(name)
        check(struct.unpack(">H", data[6:8])[0] == 65, f"{name.split('/')[-1]} major version 65")
        hit = [b.decode() for b in BANNED if b in data]
        check(not hit, f"{name.split('/')[-1]} has no debug log strings", ",".join(hit))

    # non-class payload must be untouched
    for name in ("assets/minecraft/shaders/program/blobs2.fsh",
                 "assets/legendarysurvivaloverhaul/lang/zh_cn.json",
                 "data/minecraft/tags/damage_type/no_knockback.json"):
        check(jar.read(name) == old.read(name), f"unchanged: {name}")

for ok, label, detail in checks:
    print(("PASS  " if ok else "FAIL  ") + label + (f"  [{detail}]" if detail and not ok else ""))
print()
print(f"{sum(1 for c in checks if c[0])}/{len(checks)} checks passed")
sys.exit(0 if all(c[0] for c in checks) else 1)
