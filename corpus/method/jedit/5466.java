//}}}
//{{{ createModel() method
private ShortcutsModel createModel(String actionSet, String modelLabel, String[] actions) {
    List<KeyBinding[]> bindings = new ArrayList(actions.length);
    for (String name : actions) {
        EditAction ea = jEdit.getAction(name);
        String label = ea.getLabel();
        // Skip certain actions this way
        if (label == null)
            continue;
        label = GenericGUIUtilities.prettifyMenuLabel(label);
        String tooltip = ea.getToolTip();
        addBindings(actionSet, name, label, tooltip, bindings);
    }
    return new ShortcutsModel(modelLabel, bindings);
}