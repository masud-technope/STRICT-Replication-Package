//{{{ getWidget() method
@Override
public Widget getWidget(View view) {
    Widget multiSelect = new MultiSelectWidget(view);
    return multiSelect;
}