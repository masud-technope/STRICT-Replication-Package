@Override
public String getColumnName(int index) {
    switch(index) {
        case 0:
            return jEdit.getProperty("options.shortcuts.name");
        case 1:
            return jEdit.getProperty("options.shortcuts.shortcut1");
        case 2:
            return jEdit.getProperty("options.shortcuts.shortcut2");
        case 3:
            return jEdit.getProperty("options.shortcuts.actionset");
        default:
            return null;
    }
}