//}}}
//{{{ Protected members
//{{{ error() method
/**
	 * Reports an error.
	 * You must override this method so that the mode loader can do error
	 * reporting.
	 * @param msg The error type
	 * @param subst A <code>String</code> or a <code>Throwable</code>
	 * containing specific information
	 * @since jEdit 4.2pre1
	 */
protected abstract void error(String msg, Object subst);