//}}}
//{{{ runInDispatchThreadAndWait() method
/** Runs the runnable in EDT through <code>invokeLater</code>,
	 *  but returns only after the runnable is executed.
	 *  This method is uninterruptible.
	 *  <p>Note the difference from <code>invokeAndWait</code>.
	 *  If current thread is not EDT and there are runnables
	 *  queued in EDT:
	 *  <ul><li>this method runs the runnable after them</li>
	 *  <li><code>invokeAndWait</code> runs the runnable before them
	 *  </li></ul>
	 * @param runnable the runnable to run - it should return something meaningful from 
	 *    toString() so that we can display it in the Task Monitor.
	 */
public static void runInDispatchThreadAndWait(Runnable runnable) {
    boolean interrupted = false;
    CountDownLatchRunnable run = new CountDownLatchRunnable(runnable);
    runInDispatchThread(run);
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