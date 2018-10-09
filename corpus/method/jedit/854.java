//}}}
//{{{ doTypeSelect() method
public void doTypeSelect(String str, boolean dirsOnly) {
    if (str.length() == 0)
        clearSelection();
    else if (getSelectedRow() == -1)
        doTypeSelect(str, 0, getRowCount(), dirsOnly);
    else {
        int start = getSelectionModel().getMaxSelectionIndex();
        boolean retVal = doTypeSelect(str, start, getRowCount(), dirsOnly);
        if (!retVal) {
            // scan from selection to end failed, so
            // scan from start to selection
            doTypeSelect(str, 0, start, dirsOnly);
        }
    }
}