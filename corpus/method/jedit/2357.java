/**
		Generate a printable string showing the wrapped target exception.
		If the proxy mechanism is available, allow the extended print to
		check for UndeclaredThrowableException and print that embedded error.
	*/
public String printTargetError(Throwable t) {
    String s = target.toString();
    if (Capabilities.canGenerateInterfaces())
        s += "\n" + xPrintTargetError(t);
    return s;
}