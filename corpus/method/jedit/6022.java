public void fireStateChanged() {
    if (changeListeners.size() > 0) {
        ChangeEvent event = new ChangeEvent(this);
        for (ChangeListener cl : changeListeners) {
            cl.stateChanged(event);
        }
    }
}