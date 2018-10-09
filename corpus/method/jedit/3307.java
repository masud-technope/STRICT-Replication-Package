// {{{ DockableWindowManager constructor
public  DockableWindowManager(View view, DockableWindowFactory instance, ViewConfig config) {
    this.view = view;
    this.factory = instance;
    alternateLayout = jEdit.getBooleanProperty(ALTERNATE_LAYOUT_PROP);
}