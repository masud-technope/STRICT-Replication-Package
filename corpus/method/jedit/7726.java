void fireStatusUpdated(Task task) {
    List<TaskListener> listeners = this.listeners;
    for (TaskListener listener : listeners) {
        listener.statusUpdated(task);
    }
}