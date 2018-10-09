public DockableWindowManager create(View view, DockableWindowFactory instance, ViewConfig config) {
    return new DockableWindowManagerImpl(view, instance, config);
}