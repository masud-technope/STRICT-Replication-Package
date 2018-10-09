public void addTaskListener(TaskListener listener) {
    if (!listeners.contains(listener)) {
        listeners.add(listener);
    }
}