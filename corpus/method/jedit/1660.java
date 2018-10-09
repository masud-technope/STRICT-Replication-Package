/**
        Looks up a command.
    */
public InputStream getCommand(String name) {
    if (importedCommands != null) {
        String extName = name + ".bsh";
        for (int i = importedCommands.size() - 1; i >= 0; i--) {
            CommandPathEntry entry = (CommandPathEntry) importedCommands.elementAt(i);
            InputStream in = entry.clas.getResourceAsStream(entry.path + extName);
            if (in != null)
                return in;
        }
    }
    if (parent == null)
        return null;
    else
        return parent.getCommand(name);
}