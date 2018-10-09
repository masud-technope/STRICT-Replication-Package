/**
		Evaluate the string in the specified namespace.
	*/
public Object eval(String statements, NameSpace nameSpace) throws EvalError {
    String s = (statements.endsWith(";") ? statements : statements + ";");
    return eval(new StringReader(s), nameSpace, "inline evaluation of: ``" + showEvalString(s) + "''");
}