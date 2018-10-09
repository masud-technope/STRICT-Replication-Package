//}}}
//}}}
//{{{ I/O request methods
//{{{ waitForRequests() method
/**
	 * Returns when all pending requests are complete.
	 * Must be called in the Event Dispatch Thread
	 * @since jEdit 2.5pre1
	 */
public static void waitForRequests() {
    if (!EventQueue.isDispatchThread())
        throw new IllegalStateException();
    TaskManager.instance.waitForIoTasks();
}