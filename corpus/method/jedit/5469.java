//}}}
//{{{ addBindings() method
private void addBindings(String actionSet, String name, String label, String tooltip, Collection<KeyBinding[]> bindings) {
    KeyBinding[] b = new KeyBinding[2];
    b[0] = createBinding(actionSet, name, label, tooltip, selectedKeymap.getShortcut(name + ".shortcut"));
    b[1] = createBinding(actionSet, name, label, tooltip, selectedKeymap.getShortcut(name + ".shortcut2"));
    bindings.add(b);
}