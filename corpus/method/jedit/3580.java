// The public-facing string is converted to a platform-specific
// form, but we keep the canonical shortcut string around for
// internal use.
@Override
public void setText(String s) {
    rawShortcut = (s == null) ? "" : s;
    super.setText(GUIUtilities.getPlatformShortcutLabel(s));
}