public static synchronized CollectionManager getCollectionManager() {
    if (manager == null && Capabilities.classExists("java.util.Collection")) {
        Class clas;
        try {
            clas = Class.forName("org.gjt.sp.jedit.bsh.collection.CollectionManagerImpl");
            manager = (CollectionManager) clas.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            Interpreter.debug("unable to load CollectionManagerImpl: " + e);
        }
    }
    if (manager == null)
        // default impl
        manager = new CollectionManager();
    return manager;
}