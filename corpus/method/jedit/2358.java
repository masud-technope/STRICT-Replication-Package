/**
		Extended form of print target error.
		This indirection is used to print UndeclaredThrowableExceptions 
		which are possible when the proxy mechanism is available.

		We are shielded from compile problems by using a bsh script.
		This is acceptable here because we're not in a critical path...
		Otherwise we'd need yet another dynamically loaded module just for this.
	*/
public String xPrintTargetError(Throwable t) {
    String getTarget = "import java.lang.reflect.UndeclaredThrowableException;" + "String result=\"\";" + "while ( target instanceof UndeclaredThrowableException ) {" + "	target=target.getUndeclaredThrowable(); " + "	result+=\"Nested: \"+target.toString();" + "}" + "return result;";
    Interpreter i = new Interpreter();
    try {
        i.set("target", t);
        return (String) i.eval(getTarget);
    } catch (EvalError e) {
        throw new InterpreterError("xprintarget: " + e.toString());
    }
}