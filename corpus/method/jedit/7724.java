void fireMaximumUpdated(Task task) {
    List<TaskListener> listeners = this.listeners;
    for (TaskListener listener : listeners) {
        listener.maximumUpdated(task);
    }
}