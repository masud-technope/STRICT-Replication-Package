//}}}
//{{{ setVariable() method
/**
	 * Set a beanshell variable in the namespace without overriding it
	 * @param nameSpace the namespace
	 * @param name the name of the variable
	 * @param object the value of the variable
	 * @throws UtilEvalError when there is an error
	 */
protected void setVariable(NameSpace nameSpace, String name, Object object) throws UtilEvalError {
    if (nameSpace.getVariable(name) == Primitive.VOID)
        nameSpace.setVariable(name, object, false);
}