//}}}
//{{{ unsplitCurrent() method
/**
	 * Removes the current split.
	 * @since jEdit 2.3pre2
	 */
public void unsplitCurrent() {
    if (splitPane != null) {
        lastSplitConfig = getSplitConfig();
        PerspectiveManager.setPerspectiveDirty(true);
        // find first split pane parenting current edit pane
        Component comp = editPane;
        while (!(comp instanceof JSplitPane) && comp != null) {
            comp = comp.getParent();
        }
        BufferSet.Scope scope = jEdit.getBufferSetManager().getScope();
        // of the current edit pane's parent splitter
        for (EditPane _editPane : getEditPanes()) {
            if (GenericGUIUtilities.isAncestorOf(comp, _editPane) && _editPane != editPane) {
                if (scope == BufferSet.Scope.editpane)
                    mergeBufferSets(editPane, _editPane);
                _editPane.close();
            }
        }
        JComponent parent = comp == null ? null : (JComponent) comp.getParent();
        if (parent instanceof JSplitPane) {
            JSplitPane parentSplit = (JSplitPane) parent;
            int pos = parentSplit.getDividerLocation();
            if (parentSplit.getLeftComponent() == comp)
                parentSplit.setLeftComponent(editPane);
            else
                parentSplit.setRightComponent(editPane);
            parentSplit.setDividerLocation(pos);
            parent.revalidate();
        } else {
            setMainContent(editPane);
            splitPane = null;
        }
        updateTitle();
        editPane.focusOnTextArea();
    } else
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
}