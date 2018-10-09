public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == closeBtn)
        cancel();
    else if (source == findBtn || source == find || source == replace) {
        ok();
    } else if (source == replaceBtn) {
        save(false);
        SearchAndReplace.replace(view);
    } else if (source == replaceAndFindBtn) {
        save(false);
        if (SearchAndReplace.replace(view))
            ok();
        else
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    } else if (source == replaceAllBtn) {
        if (searchSelection.isSelected() && view.getTextArea().getSelectionCount() == 0) {
            GUIUtilities.error(view, "search-no-selection", null);
            return;
        }
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (!save(false)) {
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            return;
        }
        if (searchSelection.isSelected()) {
            if (SearchAndReplace.replace(view))
                closeOrKeepDialog();
            else
                javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        } else {
            if (SearchAndReplace.replaceAll(view))
                closeOrKeepDialog();
            else
                javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        }
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
}