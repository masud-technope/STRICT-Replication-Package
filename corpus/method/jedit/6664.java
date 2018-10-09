//}}}
//{{{ setTabSizeDirtyStatus() method
/*
	 * tab sizes become dirty on font changes or when char is added or
	 * deleted inside ColumnBlock they become clean once they get calculated
	 * again inside the tab expander
	 */
public void setTabSizeDirtyStatus(boolean dirty, boolean recursive) {
    tabSizesDirty = dirty;
    if (recursive && children != null && !children.isEmpty()) {
        for (int i = 0; i < children.size(); i++) {
            ((ColumnBlock) children.elementAt(i)).setTabSizeDirtyStatus(true, true);
        }
    }
}