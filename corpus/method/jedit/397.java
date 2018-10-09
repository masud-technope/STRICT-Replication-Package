public static void main(String[] args) {
    boolean isGUI = args.length == 0;
    String javaVersion = System.getProperty("java.version");
    if (javaVersion.compareTo("1.8") < 0) {
        errorAndExit(isGUI, "You are running Java version " + javaVersion + " from " + System.getProperty("java.vendor") + ".\n" + "This installer requires Java 1.8 or later.");
    }
    if (isRunningFromExclam()) {
        errorAndExit(isGUI, "You are running the installer from a directory containing exclamation marks." + "\nIt is a known cause of failure of the installer" + "\n(http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4523159 for the curious ones)." + "\nPlease move the installer somewhere else and run it again.");
    }
    if (isGUI)
        new SwingInstall();
    else if (args.length == 1 && args[0].equals("text"))
        new ConsoleInstall();
    else if (args.length >= 2 && args[0].equals("auto"))
        new NonInteractiveInstall(args);
    else {
        System.err.println("Usage:");
        System.err.println("java -jar <installer JAR>");
        System.err.println("java -jar <installer JAR> text");
        System.err.println("java -jar <installer JAR> auto" + " <install dir> [unix-script=<dir>] [unix-man=<dir>]");
        System.err.println("text parameter starts installer in text-only mode.");
        System.err.println("auto parameter starts installer in non-interactive mode.");
    }
}