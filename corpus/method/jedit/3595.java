//}}}
//{{{ updateAssignedTo() method
private void updateAssignedTo(String shortcut) {
    String text = jEdit.getProperty("grab-key.assigned-to.none");
    KeyBinding kb = getKeyBinding(shortcut);
    if (kb != null)
        if (kb.isPrefix)
            text = jEdit.getProperty("grab-key.assigned-to.prefix", new String[] { shortcut });
        else
            text = kb.label;
    if (ok != null)
        ok.setEnabled(kb == null || !kb.isPrefix);
    assignedTo.setText(jEdit.getProperty("grab-key.assigned-to", new String[] { text }));
}