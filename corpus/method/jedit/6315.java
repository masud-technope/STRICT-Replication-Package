//}}}
//{{{ closeOrKeepDialog() method
private void closeOrKeepDialog() {
    if (keepDialog.isSelected()) {
        // the workaround causes problems!
        if (!hyperSearch.isSelected()) {
            toFront();
            requestFocus();
            find.requestFocus();
        }
    } else {
        GUIUtilities.saveGeometry(this, "search");
        setVisible(false);
    }
}