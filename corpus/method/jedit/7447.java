//}}}
//{{{ getEditPanes() method
private static void getEditPanes(List<EditPane> vec, Component comp) {
    if (comp instanceof EditPane)
        vec.add((EditPane) comp);
    else if (comp instanceof JSplitPane) {
        JSplitPane split = (JSplitPane) comp;
        getEditPanes(vec, split.getLeftComponent());
        getEditPanes(vec, split.getRightComponent());
    }
}