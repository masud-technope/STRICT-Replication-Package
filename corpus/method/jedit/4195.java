//}}}
//{{{ removeToolBar() method
public void removeToolBar(Component toolbar) {
    removeToolBar(top, topToolBars, toolbar);
    removeToolBar(bottom, bottomToolBars, toolbar);
}