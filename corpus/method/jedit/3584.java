//{{{ canClose() method
private boolean canClose() {
    String shortcutString = shortcut.getShortcut();
    if (shortcutString.length() == 0 && binding.isAssigned()) {
        // ask whether to remove the old shortcut
        int answer = GUIUtilities.confirm(GrabKeyDialog.this, "grab-key.remove-ask", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (answer == JOptionPane.YES_OPTION) {
            shortcut.setText(null);
            isOK = true;
        } else
            return false;
    }
    // check whether this shortcut already exists
    KeyBinding other = getKeyBinding(shortcutString);
    if (other == null || other == binding) {
        isOK = true;
        return true;
    }
    // check whether the other shortcut is the alt. shortcut
    if (other.name == binding.name) {
        // we don't need two identical shortcuts
        GUIUtilities.error(GrabKeyDialog.this, "grab-key.duplicate-alt-shortcut", null);
        return false;
    }
    // check whether shortcut is a prefix to others
    if (other.isPrefix) {
        // can't override prefix shortcuts
        GUIUtilities.error(GrabKeyDialog.this, "grab-key.prefix-shortcut", null);
        return false;
    }
    // ask whether to override that other shortcut
    int answer = GUIUtilities.confirm(GrabKeyDialog.this, "grab-key.duplicate-shortcut", new Object[] { other.label }, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (answer == JOptionPane.YES_OPTION) {
        if (other.shortcut != null && shortcutString.startsWith(other.shortcut)) {
            other.shortcut = null;
        }
        isOK = true;
        return true;
    } else
        return false;
//}}}
}