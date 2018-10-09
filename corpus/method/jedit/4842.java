//}}}
//{{{ initResources() method
private static void initResources() {
    builtInActionSet = new ActionSet(null, null, null, jEdit.class.getResource("actions.xml"));
    builtInActionSet.setLabel(getProperty("action-set.jEdit"));
    builtInActionSet.load();
    actionContext.addActionSet(builtInActionSet);
    DockableWindowFactory.getInstance().loadDockableWindows(null, jEdit.class.getResource("dockables.xml"), null);
    ServiceManager.loadServices(null, jEdit.class.getResource("services.xml"), null);
}