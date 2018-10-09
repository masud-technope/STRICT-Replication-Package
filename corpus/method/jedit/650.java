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
	 * @return the object
	 * @exception Exception instances are thrown when various BeanShell
	 * errors occur
	 * @since jEdit 3.2pre7
	 */
public static Object _eval(View view, NameSpace namespace, String command) throws Exception {
    return bsh._eval(view, namespace, command);
}