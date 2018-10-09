private static String[] getSavedLayouts() {
    DockingLayout docking = View.getDockingFrameworkProvider().createDockingLayout();
    String[] layouts = null;
    if (docking != null)
        layouts = docking.getSavedLayouts();
    if (layouts == null)
        return new String[0];
    return layouts;
}