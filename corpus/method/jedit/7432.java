//}}}
//{{{ getViewConfig() method
/**
	 * @return a ViewConfig instance for the current view
	 * @since jEdit 4.2pre1
	 */
public ViewConfig getViewConfig() {
    ViewConfig config = new ViewConfig();
    config.plainView = isPlainView();
    config.splitConfig = getSplitConfig();
    config.extState = getExtendedState();
    config.docking = dockableWindowManager.getDockingLayout(config);
    config.title = userTitle;
    String prefix = config.plainView ? "plain-view" : "view";
    switch(config.extState) {
        case Frame.MAXIMIZED_BOTH:
        case Frame.ICONIFIED:
            config.x = jEdit.getIntegerProperty(prefix + ".x", getX());
            config.y = jEdit.getIntegerProperty(prefix + ".y", getY());
            config.width = jEdit.getIntegerProperty(prefix + ".width", getWidth());
            config.height = jEdit.getIntegerProperty(prefix + ".height", getHeight());
            break;
        case Frame.MAXIMIZED_VERT:
            config.x = getX();
            config.y = jEdit.getIntegerProperty(prefix + ".y", getY());
            config.width = getWidth();
            config.height = jEdit.getIntegerProperty(prefix + ".height", getHeight());
            break;
        case Frame.MAXIMIZED_HORIZ:
            config.x = jEdit.getIntegerProperty(prefix + ".x", getX());
            config.y = getY();
            config.width = jEdit.getIntegerProperty(prefix + ".width", getWidth());
            config.height = getHeight();
            break;
        case Frame.NORMAL:
        default:
            config.x = getX();
            config.y = getY();
            config.width = getWidth();
            config.height = getHeight();
            break;
    }
    return config;
}