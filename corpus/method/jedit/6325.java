//}}}
//{{{ load() method
private void load() {
    wholeWord.setSelected(SearchAndReplace.getWholeWord());
    ignoreCase.setSelected(SearchAndReplace.getIgnoreCase());
    regexp.setSelected(SearchAndReplace.getRegexp());
    wrap.setSelected(SearchAndReplace.getAutoWrapAround());
    if (SearchAndReplace.getReverseSearch())
        searchBack.setSelected(true);
    else
        searchForward.setSelected(true);
    if (SearchAndReplace.getBeanShellReplace()) {
        replace.setModel("replace.script");
        beanShellReplace.setSelected(true);
    } else {
        replace.setModel("replace");
        stringReplace.setSelected(true);
    }
    SearchFileSet fileset = SearchAndReplace.getSearchFileSet();
    HistoryModel model = filter.getModel();
    if (model.getSize() != 0)
        filter.setText(model.getItem(0));
    else {
        filter.setText('*' + MiscUtilities.getFileExtension(view.getBuffer().getName()));
    }
    model = directoryField.getModel();
    if (model.getSize() != 0)
        directoryField.setText(model.getItem(0));
    else
        directoryField.setText(view.getBuffer().getDirectory());
    searchSubDirectories.setSelected(jEdit.getBooleanProperty("search.subdirs.toggle"));
    if (fileset instanceof DirectoryListSet) {
        filter.setText(((DirectoryListSet) fileset).getFileFilter());
        directoryField.setText(((DirectoryListSet) fileset).getDirectory());
        searchSubDirectories.setSelected(((DirectoryListSet) fileset).isRecursive());
    } else if (fileset instanceof AllBufferSet) {
        filter.setText(((AllBufferSet) fileset).getFileFilter());
    }
    directoryField.addCurrentToHistory();
    keepDialog.setSelected(jEdit.getBooleanProperty("search.keepDialog.toggle"));
}