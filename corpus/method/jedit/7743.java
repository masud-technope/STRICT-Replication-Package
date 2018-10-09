//{{{ runInDispatchThread() method
/**
	 * Run the runnable in EventDispatch Thread.
	 * If the current thread is EventDispatch, it will run
	 * immediately otherwise it will be queued in the DispatchThread
	 * The difference with VFSManager.runInAWTThread() method is that
	 * this one will not wait for IO Request before being executed
	 *
	 * @param runnable the runnable to run - it should return something meaningful from 
	 *    toString() so that we can display it in the Task Monitor.
	 */
public static void runInDispatchThread(Runnable runnable) {
    if (EventQueue.isDispatchThread())
        runnable.run();
    else
        EventQueue.invokeLater(runnable);
}