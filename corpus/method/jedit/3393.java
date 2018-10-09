private static boolean save(View view, String layoutName) {
    if (jEdit.getSettingsDirectory() == null) {
        GUIUtilities.error(view, "no-settings", null);
        return false;
    }
    DockingLayout docking = view.getViewConfig().docking;
    if (docking != null) {
        boolean ret = docking.saveLayout(layoutName, DockingLayout.NO_VIEW_INDEX);
        if (!ret)
            return false;
        addAction(layoutName);
    }
    return true;
}