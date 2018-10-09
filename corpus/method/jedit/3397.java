private static void createActions() {
    actions = new ActionSet("Docking Layouts");
    String[] layouts = getSavedLayouts();
    for (String layout : layouts) addAction(layout);
    jEdit.addActionSet(actions);
    actions.initKeyBindings();
}