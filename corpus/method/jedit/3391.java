public static void init() {
    createActions();
    instance = new DockingLayoutManager();
    EditBus.addToBus(instance);
}