void fireValueUpdated(Task task) {
    List<TaskListener> listeners = this.listeners;
    for (TaskListener listener : listeners) {
        listener.valueUpdated(task);
    }
}