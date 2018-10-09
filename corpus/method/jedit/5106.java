//}}}
//{{{ throwableToString() method
/**
	 * Returns a string containing the stack trace of the given throwable.
	 * @since jEdit 4.2pre6
	 */
public static String throwableToString(Throwable t) {
    StringWriter s = new StringWriter();
    t.printStackTrace(new PrintWriter(s));
    return s.toString();
}