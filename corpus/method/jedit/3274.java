//{{{ Window constructor
 Window(PluginJAR plugin, String name, String code, boolean actions, boolean movable) {
    this.plugin = plugin;
    this.name = name;
    this.code = code;
    this.movable = movable;
    if (code != null)
        loaded = true;
    if (actions) {
        ActionSet actionSet = (plugin == null ? jEdit.getBuiltInActionSet() : plugin.getActionSet());
        actionSet.addAction(new OpenAction(name));
        actionSet.addAction(new ToggleAction(name));
        actionSet.addAction(new FloatAction(name));
        String label = jEdit.getProperty(name + ".label");
        if (label == null)
            label = "NO LABEL PROPERTY: " + name;
        String[] args = { label };
        jEdit.setTemporaryProperty(name + ".label", label);
        jEdit.setTemporaryProperty(name + "-toggle.label", jEdit.getProperty("view.docking.toggle.label", args));
        jEdit.setTemporaryProperty(name + "-toggle.toggle", "true");
        jEdit.setTemporaryProperty(name + "-float.label", jEdit.getProperty("view.docking.float.label", args));
    }
//}}}
}