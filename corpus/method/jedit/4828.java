//{{{ usage() method
private static void usage() {
    System.out.println("Usage: jedit [<options>] [<files>]");
    System.out.println("	<file> +marker:<marker>: Positions caret" + " at marker <marker>");
    System.out.println("	<file> +line:<line>: Positions caret" + " at line number <line>");
    System.out.println("	<file> +line:<line>,<column>: Positions caret" + " at line number <line> and column number <column>");
    System.out.println("	--: End of options");
    System.out.println("	-background: Run in background mode");
    System.out.println("	-nobackground: Disable background mode (default)");
    System.out.println("	-gui: Only if running in background mode; open initial view (default)");
    System.out.println("	-nogui: Only if running in background mode; don't open initial view");
    System.out.println("	-log=<level>: Log messages with level equal to or higher than this to");
    System.out.println("	 standard error. <level> must be between 1 and 9. Default is 7.");
    System.out.println("	-newplainview: Client instance opens a new plain view");
    System.out.println("	-newview: Client instance opens a new view (default)");
    System.out.println("	-plugins: Load plugins (default)");
    System.out.println("	-noplugins: Don't load any plugins");
    System.out.println("	-restore: Restore previously open files (default)");
    System.out.println("	-norestore: Don't restore previously open files");
    System.out.println("	-reuseview: Client instance reuses existing view");
    System.out.println("	-quit: Quit a running instance");
    System.out.println("	-run=<script>: Run the specified BeanShell script");
    System.out.println("	-server: Read/write server info from/to $HOME/.jedit/server (default)");
    System.out.println("	-server=<name>: Read/write server info from/to $HOME/.jedit/<name>");
    System.out.println("	-noserver: Don't start edit server");
    System.out.println("	-settings=<path>: Load user-specific settings from <path>");
    System.out.println("	-nosettings: Don't load user-specific settings");
    System.out.println("	-nosplash: Don't show splash screen");
    System.out.println("	-startupscripts: Run startup scripts (default)");
    System.out.println("	-nostartupscripts: Don't run startup scripts");
    System.out.println("	-usage: Print this message and exit");
    System.out.println("	-version: Print jEdit version and exit");
    System.out.println("	-wait: Wait until the user closes the specified buffer in the server");
    System.out.println("	 instance. Does nothing if passed to the initial jEdit instance.");
    System.out.println();
    System.out.println("Report bugs to http://sourceforge.net/tracker/?group_id=588&atid=100588");
}