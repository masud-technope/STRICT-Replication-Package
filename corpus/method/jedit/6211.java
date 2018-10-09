 HighlightingTree(DefaultTreeModel model) {
    super(model);
    prop = jEdit.getProperty(HIGHLIGHT_PROP);
    if (prop != null && !prop.isEmpty()) {
        Font f = (resultTree != null) ? resultTree.getFont() : UIManager.getFont("Tree.font");
        styleTag = HtmlUtilities.style2html(prop, f);
    }
}