//}}}
//{{{ setShortcut() method
@Override
public void setShortcut(String name, String shortcut) {
    if (shortcut == null || shortcut.isEmpty()) {
        if (props.containsKey(name)) {
            modified = true;
            props.remove(name);
        }
        return;
    }
    String oldShortcut = props.getProperty(name);
    if (!shortcut.equals(oldShortcut)) {
        modified = true;
        props.setProperty(name, shortcut);
    }
}