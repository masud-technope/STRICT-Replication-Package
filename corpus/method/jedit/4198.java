//}}}
//{{{ addToolBar() method
public void addToolBar(int group, int layer, Component toolbar) {
    Entry entry = new Entry(layer, toolbar);
    if (group == View.TOP_GROUP)
        addToolBar(top, topToolBars, entry);
    else if (group == View.BOTTOM_GROUP)
        addToolBar(bottom, bottomToolBars, entry);
    else
        throw new InternalError("Invalid tool bar group");
}