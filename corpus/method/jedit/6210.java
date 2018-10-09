@Override
public String convertValueToText(Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
    String s = super.convertValueToText(value, selected, expanded, leaf, row, hasFocus);
    String newProp = jEdit.getProperty(HIGHLIGHT_PROP);
    if (newProp == null || newProp.isEmpty())
        return s;
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
    while (node != null && !(node.getUserObject() instanceof HyperSearchOperationNode)) {
        node = (DefaultMutableTreeNode) node.getParent();
    }
    if (node == null)
        return s;
    if (!newProp.equals(prop)) {
        prop = newProp;
        Font f = (resultTree != null) ? resultTree.getFont() : UIManager.getFont("Tree.font");
        styleTag = HtmlUtilities.style2html(prop, f);
    }
    SearchMatcher matcher = ((HyperSearchOperationNode) node.getUserObject()).getSearchMatcher();
    int i = s.indexOf(": ");
    if (i > 0)
        i += 2;
    else
        i = 0;
    Match m = null;
    List<Integer> matches = new ArrayList<Integer>();
    try {
        m = matcher.nextMatch(s.substring(i), true, true, true, false);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
    while (m != null) {
        matches.add(i + m.start);
        matches.add(i + m.end);
        i += m.end;
        try {
            m = matcher.nextMatch(s.substring(i), true, true, true, false);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            m = null;
        }
    }
    return HtmlUtilities.highlightString(s, styleTag, matches);
}