/**
        Import scripted or compiled BeanShell commands in the following package
        in the classpath.  You may use either "/" path or "." package notation.
        e.g. importCommands("/bsh/commands") or importCommands("bsh.commands")
        are equivalent.  If a relative path style specifier is used then it is
        made into an absolute path by prepending "/".
    */
public void importCommands(String name) {
    if (importedCommands == null)
        importedCommands = new Vector();
    // dots to slashes
    name = name.replace('.', '/');
    // absolute
    if (!name.startsWith("/"))
        name = "/" + name;
    // remove trailing (but preserve case of simple "/")
    if (name.length() > 1 && name.endsWith("/"))
        name = name.substring(0, name.length() - 1);
    // If it exists, remove it and add it at the end (avoid memory leak)
    if (importedCommands.contains(name))
        importedCommands.remove(name);
    importedCommands.addElement(name);
    nameSpaceChanged();
}