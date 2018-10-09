void fireRunning(Task task) {
    List<TaskListener> listeners = this.listeners;
    for (TaskListener listener : listeners) {
        listener.running(task);
    }
}