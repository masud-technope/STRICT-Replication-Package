//{{{ getWidget() method
@Override
public Widget getWidget(View view) {
    Widget widget = new TaskMonitorWidget(view);
    widget.getComponent().setToolTipText(jEdit.getProperty("statusbar.task-monitor.tooltip"));
    return widget;
}