//{{{ deselectDependents() method
/**
		 * deselect all plugins depending upon entry after a warning.
		 * If user cancels, reinstate install field of entry
		 * @param entry	the entry that would be no more installed
		 * @return	confirmed that deselection may proceed
		 */
private boolean deselectDependents(Entry entry) {
    Entry[] dependents = entry.getTransitiveDependents();
    if (dependents.length == 0)
        return true;
    String[] args = { entry.name };
    int result = GUIUtilities.listConfirm(window, "plugin-manager.dependency", args, dependents);
    if (result != JOptionPane.OK_OPTION) {
        entry.install = true;
        return false;
    }
    for (Entry dependent : dependents) {
        dependent.install = false;
        dependent.checked = false;
        // must setInstall() to remove the
        // plugin from its dependencies 'dependents' list
        // so that they can be unchecked if no longer required
        updateDeps(dependent);
    }
    return true;
//}}}
}