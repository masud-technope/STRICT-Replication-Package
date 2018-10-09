@Override
public Object getValueAt(int row, int col) {
    // The only place this gets used is in JTable's own display code, so
    // we translate the shortcut to platform-specific form for display here.
    KeyBinding bindingAt = getBindingAt(row, 0);
    switch(col) {
        case 0:
            return bindingAt.label;
        case 1:
            return GUIUtilities.getPlatformShortcutLabel(bindingAt.shortcut);
        case 2:
            return GUIUtilities.getPlatformShortcutLabel(getBindingAt(row, 1).shortcut);
        case 3:
            return bindingAt.actionSet;
        default:
            return null;
    }
}