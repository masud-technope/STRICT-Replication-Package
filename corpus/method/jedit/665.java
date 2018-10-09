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
	 * @param namespace The namespace to run the script in.
	 *
	 * @since jEdit 4.2pre5
	 */
public static void runScript(View view, String path, Reader in, NameSpace namespace) {
    try {
        _runScript(view, path, in, namespace);
    } catch (Throwable e) {
        Log.log(Log.ERROR, BeanShell.class, e);
        bsh.handleException(view, path, e);
    }
}