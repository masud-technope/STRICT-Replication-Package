//}}}
//{{{ init() method
/**
	 * Initializes the log.
	 * @param stdio If true, standard output and error will be
	 * intercepted and sent to the log. The <code>urgency</code>
	 * for these implicit log entries is <code>NOTICE</code>
	 * and <code>ERROR</code> accordingly. Note that in such a situation
	 * <code>System.out.print()</code> calls will not appear on standard
	 * output, if default output level is higher than <code>NOTICE</code>.
	 * @param level Messages with this log level or higher will
	 * be printed to the system console.
	 * @since jEdit 3.2pre4
	 */
public static void init(boolean stdio, int level) {
    if (stdio && System.out == realOut && System.err == realErr) {
        System.setOut(createPrintStream(NOTICE, null));
        System.setErr(createPrintStream(ERROR, null));
    }
    Log.level = level;
    // Log some stuff
    log(MESSAGE, Log.class, "When reporting bugs, please" + " include the following information:");
    String[] props = { "java.version", "java.vm.version", "java.vm.name", "java.runtime.version", "java.runtime.name", "java.vendor", "java.compiler", "os.name", "os.version", "os.arch", "user.home", "java.home", "java.class.path" };
    for (String prop : props) {
        log(MESSAGE, Log.class, prop + '=' + System.getProperty(prop));
    }
}