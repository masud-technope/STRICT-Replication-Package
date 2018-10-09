/*	End methods for interacting with Parser */
void loadRCFiles() {
    try {
        String rcfile = // Default is c:\windows under win98, $HOME under Unix
        System.getProperty("user.home") + File.separator + ".bshrc";
        source(rcfile, globalNameSpace);
    } catch (Exception e) {
        if (Interpreter.DEBUG)
            debug("Could not find rc file: " + e);
    }
}