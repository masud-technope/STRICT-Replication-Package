//}}}
//{{{ sendShortcutPrefixOff() method
protected void sendShortcutPrefixOff() {
    if (shortcutOn) {
        ShortcutPrefixActiveEvent.firePrefixStateChange(null, false);
        shortcutOn = false;
    }
}