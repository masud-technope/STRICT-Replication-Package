//}}}
//{{{ runInBackground() method
/**
	 * Run the runnable in the threadpool.
	 * The runnable will be encapsulated in a {@link Task}
	 * @see #runInBackground(Task)
	 *
	 * @param runnable the runnable to run - it should return something meaningful from 
	     toString() so that we can display it in the Task Monitor.
	 */
public static void runInBackground(Runnable runnable) {
    Task task;
    if (runnable instanceof Task) {
        task = (Task) runnable;
    } else {
        task = TaskManager.decorate(runnable);
    }
    TaskManager.instance.fireWaiting(task);
    threadPool.execute(task);
}