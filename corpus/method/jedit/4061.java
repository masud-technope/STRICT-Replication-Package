//{{{ getWidget() class
public Widget getWidget(View view) {
    Widget widget = new LockedWidget(view);
    return widget;
}