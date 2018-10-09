//{{{ getInstance() method
public static synchronized DockableWindowFactory getInstance() {
    if (instance == null)
        instance = new DockableWindowFactory();
    return instance;
}