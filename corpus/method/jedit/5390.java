//}}}
//{{{ getSelectionAreaWidth() method
public static int getSelectionAreaWidth() {
    int n = jEdit.getIntegerProperty("view.gutter.selectionAreaWidth", DEFAULT_SELECTION_GUTTER_WIDTH);
    if (n < 0)
        n = DEFAULT_SELECTION_GUTTER_WIDTH;
    return n;
}