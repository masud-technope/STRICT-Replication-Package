//}}}
//{{{ eval() method
/**
	 * Evaluates the specified BeanShell expression. Errors are reported in
	 * a dialog box.
	 * @param param The parameter
	 * @param namespace The namespace
	 * @param command The expression
	 * @return an object
	 */
public Object eval(T param, NameSpace namespace, String command) {
    try {
        return _eval(param, namespace, command);
    } catch (Throwable e) {
        Log.log(Log.ERROR, BeanShellFacade.class, e);
        handleException(param, null, e);
    }
    return null;
}