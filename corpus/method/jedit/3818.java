//}}}
//{{{ ok() method
public void ok(boolean dispose) {
    if (currentPane != null)
        jEdit.setProperty(name + ".last", currentPane.getName());
    org.jedit.options.OptionTreeModel m = (org.jedit.options.OptionTreeModel) paneTree.getModel();
    save(m.getRoot());
    /* This will fire the PROPERTIES_CHANGED event */
    jEdit.propertiesChanged();
    // Save settings to disk
    jEdit.saveSettings();
    // get rid of this dialog if necessary
    if (dispose)
        dispose();
}