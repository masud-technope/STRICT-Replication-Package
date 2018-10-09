@Override
public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == highlight) {
        String prop = jEdit.getProperty(HIGHLIGHT_PROP);
        Font f = (resultTree != null) ? resultTree.getFont() : UIManager.getFont("Tree.font");
        SyntaxStyle style = new StyleEditor(jEdit.getActiveView(), HtmlUtilities.parseHighlightStyle(prop, f), "hypersearch").getStyle();
        if (style != null)
            jEdit.setProperty(HIGHLIGHT_PROP, GUIUtilities.getStyleString(style));
        updateHighlightStatus();
    } else if (source == clear) {
        removeAllNodes();
    } else if (source == multi) {
        multiStatus = !multiStatus;
        updateMultiStatus();
        if (!multiStatus) {
            for (int i = resultTreeRoot.getChildCount() - 2; i >= 0; i--) {
                resultTreeModel.removeNodeFromParent((MutableTreeNode) resultTreeRoot.getChildAt(i));
            }
        }
    } else if (source == stop) {
        TaskManager.instance.cancelTasksByClass(HyperSearchRequest.class);
    }
}