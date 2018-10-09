public void removeChangeListener(ChangeListener cl) {
    if (cl != null) {
        changeListeners.remove(cl);
    }
}