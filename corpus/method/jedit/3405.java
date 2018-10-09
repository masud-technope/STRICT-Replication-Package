public void handleMessage(EBMessage message) {
    boolean autoLoadModeLayout = jEdit.getBooleanProperty(DockingOptionPane.AUTO_LOAD_MODE_LAYOUT_PROP, false);
    if (!autoLoadModeLayout)
        return;
    if (message instanceof ViewUpdate) {
        ViewUpdate vu = (ViewUpdate) message;
        if (vu.getWhat() == ViewUpdate.CLOSED) {
            View view = jEdit.getActiveView();
            String mode = currentMode.get(view);
            saveModeLayout(view, mode);
            return;
        }
    }
    // Check for a change in the edit mode
    View view = jEdit.getActiveView();
    if (view == null)
        return;
    if (!canChangeEditMode(message))
        return;
    String newMode = getCurrentEditMode(view);
    String mode = currentMode.get(view);
    boolean sameMode = (mode == null && newMode == null) || (mode != null && mode.equals(newMode));
    if (!sameMode) {
        boolean autoSaveModeLayout = jEdit.getBooleanProperty(DockingOptionPane.AUTO_SAVE_MODE_LAYOUT_PROP, false);
        if (autoSaveModeLayout)
            saveModeLayout(view, mode);
        currentMode.put(view, newMode);
        loadModeLayout(view, newMode);
    }
}