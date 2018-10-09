//{{{ _loadMenuItem() method
private static JMenuItem _loadMenuItem(String name, ActionContext context, boolean setMnemonic) {
    String label = jEdit.getProperty(name + ".label", name);
    char mnemonic;
    int index = label.indexOf('$');
    if (index != -1 && label.length() - index > 1) {
        mnemonic = Character.toLowerCase(label.charAt(index + 1));
        label = label.substring(0, index).concat(label.substring(++index));
    } else {
        mnemonic = '\0';
    }
    JMenuItem mi;
    if (jEdit.getBooleanProperty(name + ".toggle")) {
        mi = new EnhancedCheckBoxMenuItem(label, name, context);
    } else {
        mi = new EnhancedMenuItem(label, name, context);
    }
    if (!OperatingSystem.isMacOS() && setMnemonic && mnemonic != '\0') {
        mi.setMnemonic(mnemonic);
    }
    Icon itemIcon = loadIcon(jEdit.getProperty(name + ".icon.small"));
    if (itemIcon != null) {
        mi.setIcon(itemIcon);
    }
    return mi;
}