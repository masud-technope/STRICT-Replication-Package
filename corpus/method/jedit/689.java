//}}}
//{{{ _eval() method
/**
	 * Evaluates the specified BeanShell expression. Unlike
	 * <code>eval()</code>, this method passes any exceptions to the caller.
	 *
	 * @param view The view. Within the script, references to
	 * <code>buffer</code>, <code>textArea</code> and <code>editPane</code>
	 * are determined with reference to this parameter.
	 * @param namespace The namespace
	 * @param command The expression
	 * @return an object
	 * @exception Exception instances are thrown when various BeanShell
	 * errors occur
	 */
public Object _eval(T view, NameSpace namespace, String command) throws Exception {
    Interpreter interp = createInterpreter(namespace);
    try {
        setupDefaultVariables(namespace, view);
        if (Debug.BEANSHELL_DEBUG)
            Log.log(Log.DEBUG, BeanShellFacade.class, command);
        return interp.eval(command);
    } catch (Exception e) {
        unwrapException(e);
        return null;
    } finally {
        try {
            resetDefaultVariables(namespace);
        } catch (UtilEvalError e) {
        }
    }
}