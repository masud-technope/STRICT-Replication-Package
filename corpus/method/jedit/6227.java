//{{{ updateHighlightStatus() method
private void updateHighlightStatus() {
    String prop = jEdit.getProperty(HIGHLIGHT_PROP);
    if (prop != null && !prop.isEmpty())
        highlight.setIcon(GUIUtilities.loadIcon(jEdit.getProperty("hypersearch-results.match.highlight.icon")));
    else
        highlight.setIcon(GUIUtilities.loadIcon(jEdit.getProperty("hypersearch-results.match.normal.icon")));
    resultTree.repaint();
}