//}}}
//{{{ getKeymapState() method
@Override
public State getKeymapState(String name) {
    File systemKeymapFile = getSystemKeymapFile(name);
    File userKeymapFile = getUserKeymapFile(name);
    if (userKeymapFile.isFile()) {
        if (systemKeymapFile.isFile())
            return State.SystemModified;
        return State.User;
    }
    if (systemKeymapFile.isFile())
        return State.System;
    return State.Unknown;
}