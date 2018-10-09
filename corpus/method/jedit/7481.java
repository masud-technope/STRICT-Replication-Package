//}}}
//{{{ split() method
/**
	 * Splits the view.
	 * @param orientation the orientation {@link javax.swing.JSplitPane#HORIZONTAL_SPLIT} or
	 * {@link javax.swing.JSplitPane#VERTICAL_SPLIT}
	 * @return the new editPane
	 * @since jEdit 4.1pre2
	 */
public EditPane split(int orientation) {
    PerspectiveManager.setPerspectiveDirty(true);
    editPane.saveCaretInfo();
    EditPane oldEditPane = editPane;
    EditPane newEditPane = createEditPane(oldEditPane.getBufferSet(), oldEditPane.getBuffer());
    //		setEditPane(newEditPane);
    newEditPane.loadCaretInfo();
    JComponent oldParent = (JComponent) oldEditPane.getParent();
    final JSplitPane newSplitPane = new JSplitPane(orientation);
    newSplitPane.setOneTouchExpandable(true);
    newSplitPane.setBorder(null);
    newSplitPane.setMinimumSize(new Dimension(0, 0));
    newSplitPane.setResizeWeight(0.5);
    int parentSize = orientation == JSplitPane.VERTICAL_SPLIT ? oldEditPane.getHeight() : oldEditPane.getWidth();
    final int dividerPosition = (int) ((parentSize - newSplitPane.getDividerSize()) * 0.5);
    newSplitPane.setDividerLocation(dividerPosition);
    if (oldParent instanceof JSplitPane) {
        JSplitPane oldSplitPane = (JSplitPane) oldParent;
        int dividerPos = oldSplitPane.getDividerLocation();
        Component left = oldSplitPane.getLeftComponent();
        if (left == oldEditPane)
            oldSplitPane.setLeftComponent(newSplitPane);
        else
            oldSplitPane.setRightComponent(newSplitPane);
        newSplitPane.setLeftComponent(oldEditPane);
        newSplitPane.setRightComponent(newEditPane);
        oldSplitPane.setDividerLocation(dividerPos);
    } else {
        splitPane = newSplitPane;
        newSplitPane.setLeftComponent(oldEditPane);
        newSplitPane.setRightComponent(newEditPane);
        setMainContent(newSplitPane);
    }
    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            newSplitPane.setDividerLocation(dividerPosition);
        }
    });
    newEditPane.focusOnTextArea();
    return newEditPane;
}