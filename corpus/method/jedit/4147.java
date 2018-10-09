//}}}
//{{{ _getWidget() method
private Widget _getWidget(String name) {
    StatusWidgetFactory widgetFactory = (StatusWidgetFactory) ServiceManager.getService("org.gjt.sp.jedit.gui.statusbar.StatusWidgetFactory", name);
    if (widgetFactory == null) {
        return null;
    }
    return widgetFactory.getWidget(view);
}