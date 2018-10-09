//{{{ getWidget() method
public Widget getWidget(View view) {
    Widget overwrite = new OverwriteWidget(view);
    return overwrite;
}