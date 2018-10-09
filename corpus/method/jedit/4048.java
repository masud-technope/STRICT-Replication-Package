//{{{ getWidget() method
public Widget getWidget(View view) {
    Widget lastModifiedWidget = new LastModifiedWidget(view);
    return lastModifiedWidget;
}