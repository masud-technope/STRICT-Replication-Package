public void removeTaskListener(TaskListener listener) {
    if (listeners.contains(listener)) {
        listeners.remove(listener);
    }
}