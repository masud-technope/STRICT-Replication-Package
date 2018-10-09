//}}}
//{{{ unsplit() method
/**
	 * Unsplits the view.
	 * @since jEdit 2.3pre2
	 */
public void unsplit() {
    if (splitPane != null) {
        lastSplitConfig = getSplitConfig();
        PerspectiveManager.setPerspectiveDirty(true);
        BufferSet.Scope scope = jEdit.getBufferSetManager().getScope();
        for (EditPane _editPane : getEditPanes()) {
            if (editPane != _editPane) {
                if (scope == BufferSet.Scope.editpane)
                    mergeBufferSets(editPane, _editPane);
                _editPane.close();
            }
        }
        setMainContent(editPane);
        splitPane = null;
        updateTitle();
        editPane.focusOnTextArea();
    } else
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
}