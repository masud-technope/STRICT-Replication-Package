//}}}
//{{{ unwrapException() method
/**
	 * This extracts an exception from a 'wrapping' exception, as BeanShell
	 * sometimes throws. This gives the user a more accurate error traceback
	 * @param e the exception
	 * @throws Exception on error
	 */
protected static void unwrapException(Exception e) throws Exception {
    if (e instanceof TargetError) {
        Throwable t = ((TargetError) e).getTarget();
        if (t instanceof Exception)
            throw (Exception) t;
        else if (t instanceof Error)
            throw (Error) t;
    }
    if (e instanceof InvocationTargetException) {
        Throwable t = ((InvocationTargetException) e).getTargetException();
        if (t instanceof Exception)
            throw (Exception) t;
        else if (t instanceof Error)
            throw (Error) t;
    }
    throw e;
}