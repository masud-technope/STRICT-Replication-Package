//}}}
//{{{ reloadModels() method
private void reloadModels() {
    models.clear();
    allBindings.clear();
    List<KeyBinding[]> allBindings = new ArrayList();
    Collection<String> knownBindings = new HashSet();
    ActionSet[] actionSets = jEdit.getActionSets();
    for (ActionSet actionSet : actionSets) {
        if (actionSet.getActionCount() != 0) {
            String modelLabel = actionSet.getLabel();
            if (modelLabel == null) {
                Log.log(Log.ERROR, this, "Empty action set: " + actionSet.getPluginJAR());
            }
            ShortcutsModel model = createModel(actionSet.getLabel(), modelLabel, actionSet.getActionNames());
            models.add(model);
            List<KeyBinding[]> bindings = model.getBindings();
            for (KeyBinding[] binding : bindings) {
                String name = binding[0].name;
                if (!knownBindings.contains(name)) {
                    knownBindings.add(name);
                    allBindings.add(binding);
                }
            }
        }
    }
    if (models.size() > 1)
        models.add(new ShortcutsModel(ShortcutsModel.ALL, allBindings));
    ShortcutsModel delegated = filteredModel.getDelegated();
    Collections.sort(models, new StandardUtilities.StringCompare<ShortcutsModel>(true));
    if (delegated == null) {
        delegated = models.get(0);
    } else {
        for (ShortcutsModel model : models) {
            // Find the model with the same name
            if (model.toString().equals(delegated.toString())) {
                delegated = model;
                break;
            }
        }
    }
    filteredModel.setDelegated(delegated);
    filteredModel.fireTableDataChanged();
}