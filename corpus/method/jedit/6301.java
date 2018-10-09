//}}}
//{{{ find() method
private void find(boolean reverse) {
    timer.stop();
    String text = find.getText();
    //{{{ If nothing entered, show search and replace dialog box
    if (text.length() == 0) {
        jEdit.setBooleanProperty("search.hypersearch.toggle", hyperSearch.isSelected());
        SearchDialog.showSearchDialog(view, null, SearchDialog.CURRENT_BUFFER);
    //}}}
    } else //{{{ HyperSearch
    if (hyperSearch.isSelected()) {
        if (isRemovable) {
            view.removeToolBar(this);
        } else
            find.setText(null);
        SearchAndReplace.setSearchString(text);
        SearchAndReplace.setSearchFileSet(new CurrentBufferSet());
        SearchAndReplace.hyperSearch(view);
    //}}}
    } else //{{{ Incremental search
    {
        // on enter, start search from end
        // of current match to find next one
        int start;
        JEditTextArea textArea = view.getTextArea();
        Selection s = textArea.getSelectionAtOffset(textArea.getCaretPosition());
        if (s == null)
            start = textArea.getCaretPosition();
        else if (reverse)
            start = s.getStart();
        else
            start = s.getEnd();
        if (!incrementalSearch(start, reverse)) {
            // beginning
            if (!incrementalSearch(reverse ? view.getBuffer().getLength() : 0, reverse)) {
                // not found at all.
                view.getStatus().setMessageAndClear(jEdit.getProperty("view.status.search-not-found"));
            } else {
                // inform user search restarted
                view.getStatus().setMessageAndClear(jEdit.getProperty("view.status.auto-wrap"));
                // beep if beep property set
                if (jEdit.getBooleanProperty("search.beepOnSearchAutoWrap")) {
                    javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
                }
            }
        }
    //}}}
    }
}