private static void load(View view, String layoutName) {
    if (jEdit.getSettingsDirectory() == null) {
        GUIUtilities.error(view, "no-settings", null);
        return;
    }
    DockingLayout docking = View.getDockingFrameworkProvider().createDockingLayout();
    if (docking.loadLayout(layoutName, DockingLayout.NO_VIEW_INDEX))
        view.getDockableWindowManager().setDockingLayout(docking);
}