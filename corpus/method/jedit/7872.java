public void ok(boolean dispose) {
    GUIUtilities.saveGeometry(this, getName());
    for (OptionPane op : panes) {
        if (shownPanes.contains(op))
            op.save();
    }
    /* This will fire the PROPERTIES_CHANGED event */
    jEdit.propertiesChanged();
    // Save settings to disk
    jEdit.saveSettings();
    // get rid of this dialog if necessary
    if (dispose)
        dispose();
}