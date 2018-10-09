//}}}
//{{{ runScript() method
/**
	 * Runs the specified script.
	 * Unlike the {@link BeanShell#runScript(View,String,Reader,boolean)}
	 * method, this method can run scripts supported
	 * by any registered macro handler.
	 * @param view The view
	 * @param path The VFS path of the script
	 * @param ignoreUnknown If true, then unknown file types will be
	 * ignored; otherwise, a warning message will be printed and they will
	 * be evaluated as BeanShell scripts.
	 *
	 * @since jEdit 4.1pre2
	 */
public static void runScript(View view, String path, boolean ignoreUnknown) {
    Handler handler = getHandlerForPathName(path);
    if (handler != null) {
        try {
            Macro newMacro = handler.createMacro(MiscUtilities.getFileName(path), path);
            newMacro.invoke(view);
        } catch (Exception e) {
            Log.log(Log.ERROR, Macros.class, e);
            return;
        }
        return;
    }
    // this file
    if (ignoreUnknown) {
        Log.log(Log.NOTICE, Macros.class, path + ": Cannot find a suitable macro handler");
    } else {
        Log.log(Log.ERROR, Macros.class, path + ": Cannot find a suitable macro handler, " + "assuming BeanShell");
        getHandler("beanshell").createMacro(path, path).invoke(view);
    }
}