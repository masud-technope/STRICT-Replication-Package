//}}}
//{{{ ok() method
public void ok() {
    try {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (!save(false))
            return;
        if (searchSelection.isSelected() && view.getTextArea().getSelectionCount() == 0) {
            GUIUtilities.error(view, "search-no-selection", null);
            return;
        }
        if (hyperSearch.isSelected() || searchSelection.isSelected()) {
            if (SearchAndReplace.hyperSearch(view, searchSelection.isSelected()))
                closeOrKeepDialog();
        } else {
            if (SearchAndReplace.find(view))
                closeOrKeepDialog();
            else {
                toFront();
                requestFocus();
                find.requestFocus();
            }
        }
    } finally {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
}