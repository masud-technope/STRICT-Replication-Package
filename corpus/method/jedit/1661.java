/**
        Remove a URLfrom the command path.
    */
public void removeCommandPath(String path, Class clas) {
    if (importedCommands == null)
        return;
    for (int i = 0; i < importedCommands.size(); i++) {
        CommandPathEntry entry = (CommandPathEntry) importedCommands.elementAt(i);
        if (entry.path.equals(path) && entry.clas == clas) {
            importedCommands.removeElementAt(i);
            return;
        }
    }
}