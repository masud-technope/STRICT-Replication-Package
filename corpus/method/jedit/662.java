//}}}
//{{{ eval() method
/**
	 * Evaluates the specified BeanShell expression. Errors are reported in
	 * a dialog box.
	 * @param view The view. Within the script, references to
	 * <code>buffer</code>, <code>textArea</code> and <code>editPane</code>
	 * are determined with reference to this parameter.
	 * @param namespace The namespace
	 * @param command The expression
	 * @return an object
	 * @since jEdit 4.0pre8
	 */
public static Object eval(View view, NameSpace namespace, String command) {
    return bsh.eval(view, namespace, command);
}