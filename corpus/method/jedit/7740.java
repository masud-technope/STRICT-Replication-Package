/**
	 * Run the task in the threadpool.
	 *
	 * @param task the task to run
	 */
public static void runInBackground(Task task) {
    TaskManager.instance.fireWaiting(task);
    threadPool.execute(task);
}