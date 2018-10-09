/**
	 * Return the number of IO tasks in queue.
	 *
	 * @return the number of IO tasks in queue
	 * @since jEdit 5.1pre1
	 */
public int countIoTasks() {
    int size = 0;
    synchronized (tasks) {
        for (Task task : tasks) if (task instanceof IoTask)
            size++;
    }
    return size;
}