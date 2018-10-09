//}}}
//{{{ parseHighlightStyle()
SyntaxStyle parseHighlightStyle(String style) {
    Font f = (resultTree != null) ? resultTree.getFont() : UIManager.getFont("Tree.font");
    return HtmlUtilities.parseHighlightStyle(style, f);
}