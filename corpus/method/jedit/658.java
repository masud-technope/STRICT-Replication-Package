//}}}
//{{{ runScript() method
/**
	 * Runs a BeanShell script. Errors are shown in a dialog box.<p>
	 *
	 * If the <code>in</code> parameter is non-null, the script is
	 * read from that stream; otherwise it is read from the file identified
	 * by <code>path</code>.<p>
	 *
	 * The <code>scriptPath</code> BeanShell variable is set to the path
	 * name of the script.
	 *
	 * @param view The view. Within the script, references to
	 * <code>buffer</code>, <code>textArea</code> and <code>editPane</code>
	 * are determined with reference to this parameter.
	 * @param path The script file's VFS path.
	 * @param in The reader to read the script from, or <code>null</code>.
	 * @param ownNamespace If set to <code>false</code>, methods and
	 * variables defined in the script will be available to all future
	 * uses of BeanShell; if set to <code>true</code>, they will be lost as
	 * soon as the script finishes executing. jEdit uses a value of
	 * <code>false</code> when running startup scripts, and a value of
	 * <code>true</code> when running all other macros.
	 *
	 * @since jEdit 4.0pre7
	 */
public static void runScript(View view, String path, Reader in, boolean ownNamespace) {
    try {
        _runScript(view, path, in, ownNamespace);
    } catch (Throwable e) {
        Log.log(Log.ERROR, BeanShell.class, e);
        bsh.handleException(view, path, e);
    }
}