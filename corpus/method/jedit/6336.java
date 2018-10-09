//}}}
//{{{ getSearchDialog() method
public static SearchDialog getSearchDialog(View view) {
    SearchDialog searchDialog = viewHash.get(view);
    if (searchDialog == null) {
        searchDialog = new SearchDialog(view);
        searchDialog.setAutoRequestFocus(true);
        viewHash.put(view, searchDialog);
    }
    return searchDialog;
}