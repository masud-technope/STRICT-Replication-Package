//}}}
//{{{ getDockingFrameworkProvider() method
public static DockingFrameworkProvider getDockingFrameworkProvider() {
    if (dockingFrameworkProvider == null) {
        String framework = getDockingFrameworkName();
        dockingFrameworkProvider = (DockingFrameworkProvider) ServiceManager.getService(DOCKING_FRAMEWORK_PROVIDER_SERVICE, framework);
        if (dockingFrameworkProvider == null) {
            Log.log(Log.ERROR, View.class, "No docking framework " + framework + " available, using the original one");
            dockingFrameworkProvider = (DockingFrameworkProvider) ServiceManager.getService(DOCKING_FRAMEWORK_PROVIDER_SERVICE, ORIGINAL_DOCKING_FRAMEWORK);
        }
    }
    return dockingFrameworkProvider;
}