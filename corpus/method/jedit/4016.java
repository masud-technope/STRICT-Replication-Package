//{{{ getWidget() method
@Override
public Widget getWidget(View view) {
    Widget errorWidget = new ErrorWidget(view);
    return errorWidget;
}