/**
        Adds a URL to the command path.
    */
public void addCommandPath(String path, Class clas) {
    if (importedCommands == null)
        importedCommands = new Vector();
    if (!path.endsWith("/"))
        path += '/';
    importedCommands.addElement(new CommandPathEntry(path, clas));
}