//}}}
//{{{ runInDispatchThreadNow() method
/**
	 * Runs the runnable in EDT through <code>invokeAndWait</code>.
	 * Even if the thread gets interrupted, the call does not return
	 * until the runnable finishes (uninterruptible method).
	 * <p>
	 * This method uses <code>EventQueue.invokeAndWait</code>, so
	 * the following remark applies:
	 * <p>If you use invokeAndWait(), make sure that the thread that calls
	 * invokeAndWait() does not hold any locks that other threads might
	 * need while the call is occurring.
	 * From the article:
	 * <a href="http://java.sun.com/products/jfc/tsc/articles/threads/threads1.html#event_dispatching">
	 * Threads and Swing</a>
	 * @param runnable the runnable to run - it should return something meaningful from 
	 *    toString() so that we can display it in the Task Monitor.
	 */
public static void runInDispatchThreadNow(Runnable runnable) {
    boolean interrupted = false;
    CountDownLatchRunnable run = new CountDownLatchRunnable(runnable);
    try {
        EventQueue.invokeAndWait(run);
    } catch (InterruptedException e) {
        interrupted = true;
    } catch (InvocationTargetException ite) {
        Throwable cause = ite.getCause();
        if (cause instanceof RuntimeException)
            throw (RuntimeException) cause;
        else {
            Log.log(Log.ERROR, ThreadUtilities.class, "Invocation Target Exception:");
            Log.log(Log.ERROR, runnable.getClass(), cause);
        }
    }
    while (run.done.getCount() > 0) {
        try {
            run.done.await();
        } catch (InterruptedException e) {
            interrupted = true;
        }
    }
    if (interrupted)
        Thread.currentThread().interrupt();
}