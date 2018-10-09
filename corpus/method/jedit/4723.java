//}}}
//{{{ getRequestCount() method
/**
	 * Returns the number of pending I/O requests.
	 */
public static int getRequestCount() {
    return TaskManager.instance.countIoTasks();
}