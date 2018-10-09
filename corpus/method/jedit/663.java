//}}}
//{{{ _runScript() method
/**
	 * Runs a BeanShell script. Errors are passed to the caller.<p>
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
	 * @exception Exception instances are thrown when various BeanShell errors
	 * occur
	 * @since jEdit 4.2pre5
	 */
public static void _runScript(View view, String path, Reader in, NameSpace namespace) throws Exception {
    Log.log(Log.MESSAGE, BeanShell.class, "Running script " + path);
    Interpreter interp = BeanShellFacade.createInterpreter(namespace);
    try {
        if (in == null) {
            Buffer buffer = jEdit.openTemporary(null, null, path, false);
            if (!buffer.isLoaded())
                TaskManager.instance.waitForIoTasks();
            in = new StringReader(buffer.getText(0, buffer.getLength()));
        }
        bsh.setupDefaultVariables(namespace, view);
        interp.set("scriptPath", path);
        running = true;
        interp.eval(in, namespace, path);
    } catch (Exception e) {
        BeanShellFacade.unwrapException(e);
    } finally {
        running = false;
        try {
            // no need to do this for macros!
            if (namespace == bsh.getNameSpace()) {
                bsh.resetDefaultVariables(namespace);
                interp.unset("scriptPath");
            }
        } catch (EvalError e) {
        }
    }
}