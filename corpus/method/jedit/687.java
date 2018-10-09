//}}}
//{{{ eval() method
/**
	 * Evaluates the specified BeanShell expression with the global namespace
	 * @param param The parameter
	 * @param command The expression
	 * @return an object
	 */
public Object eval(T param, String command) {
    return eval(param, global, command);
}