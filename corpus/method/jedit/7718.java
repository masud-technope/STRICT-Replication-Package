/** cancel a task by its class
	 * @since jEdit 5.1pre1
	 */
public void cancelTasksByClass(Class<? extends Task> clazz) {
    synchronized (tasks) {
        for (Task task : tasks) {
            if (task.getClass().equals(clazz))
                task.cancel();
        }
    }
}