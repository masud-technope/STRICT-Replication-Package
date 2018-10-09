// End ConsoleInterface
/**
		Print a debug message on debug stream associated with this interpreter
		only if debugging is turned on.
	*/
public static final void debug(String s) {
    if (DEBUG)
        debug.println("// Debug: " + s);
}