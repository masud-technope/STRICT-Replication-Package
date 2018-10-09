/**
	 * Encapsulate a runnable into a task.
	 * It is done by the Threadpool when receiving a simple Runnable
	 *
	 * @param runnable the runnable to encapsulate
	 * @return a Task
	 */
static Task decorate(Runnable runnable) {
    return new MyTask(runnable);
}