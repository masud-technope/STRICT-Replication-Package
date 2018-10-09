//{{{ ErrorHighlight constructor
 ErrorHighlight(View view) {
    String defaultFont = jEdit.getProperty("view.font");
    int defaultFontSize = jEdit.getIntegerProperty("view.fontsize", 12);
    SyntaxStyle invalid = SyntaxUtilities.parseStyle(jEdit.getProperty("view.style.invalid"), defaultFont, defaultFontSize, true);
    foregroundColor = invalid.getForegroundColor();
    setForeground(foregroundColor);
    setBackground(jEdit.getColorProperty("view.status.background"));
    addMouseListener(new MyMouseAdapter(view));
//}}}
}