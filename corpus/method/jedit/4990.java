//}}}
//{{{ loadMacros() method
/**
	 * Rebuilds the macros list, and sends a MacrosChanged message
	 * (views update their Macros menu upon receiving it)
	 * @since jEdit 2.2pre4
	 */
public static void loadMacros() {
    jEdit.removeActionSet(macroActionSet);
    macroActionSet.removeAllActions();
    macroHierarchy.removeAllElements();
    macroHash.clear();
    // since subsequent macros with the same name are ignored,
    // load user macros first so that they override the system
    // macros.
    String settings = jEdit.getSettingsDirectory();
    if (settings != null) {
        userMacroPath = MiscUtilities.constructPath(settings, "macros");
        loadMacros(macroHierarchy, "", new File(userMacroPath));
    }
    if (jEdit.getJEditHome() != null) {
        systemMacroPath = MiscUtilities.constructPath(jEdit.getJEditHome(), "macros");
        loadMacros(macroHierarchy, "", new File(systemMacroPath));
    }
    jEdit.addActionSet(macroActionSet);
    EditBus.send(new DynamicMenuChanged("macros"));
}