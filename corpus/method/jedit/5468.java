//}}}
//{{{ createBinding() method
private KeyBinding createBinding(String actionSet, String name, String label, String tooltip, String shortcut) {
    if (shortcut != null && shortcut.isEmpty())
        shortcut = null;
    KeyBinding binding = new KeyBinding(name, label, tooltip, shortcut, false);
    binding.actionSet = actionSet;
    allBindings.add(binding);
    return binding;
}