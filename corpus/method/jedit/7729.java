void fireWaiting(Task task) {
    tasks.add(task);
    List<TaskListener> listeners = this.listeners;
    for (TaskListener listener : listeners) {
        listener.waiting(task);
    }
}