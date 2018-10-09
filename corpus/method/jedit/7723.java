/**
	 * Visit all tasks.
	 * While doing this the task list is locked
	 *
	 * @param visitor the visitor
	 */
public void visit(TaskVisitor visitor) {
    synchronized (tasks) {
        for (Task task : tasks) {
            visitor.visit(task);
        }
    }
}