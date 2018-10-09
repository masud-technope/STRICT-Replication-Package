//}}}
//{{{ deleteUserKeymap() method
@Override
public void deleteUserKeymap(String name) {
    State keymapState = getKeymapState(name);
    if (keymapState == State.User) {
        File userFile = getUserKeymapFile(name);
        userFile.delete();
    }
}