public void save() {
    for (KeyBinding[] binding : bindings) {
        selectedKeymap.setShortcut(binding[0].name + ".shortcut", binding[0].shortcut);
        selectedKeymap.setShortcut(binding[1].name + ".shortcut2", binding[1].shortcut);
    }
}