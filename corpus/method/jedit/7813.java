//}}}
//{{{ resetKeymap() method
@Override
public void resetKeymap(String name) {
    State keymapState = getKeymapState(name);
    if (keymapState == State.SystemModified) {
        File userFile = getUserKeymapFile(name);
        userFile.delete();
    }
}