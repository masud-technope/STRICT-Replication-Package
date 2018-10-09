//{{{ cancel() method
/**
	 * Cancel the task
	 */
public void cancel() {
    if (cancellable && thread != null)
        thread.interrupt();
}