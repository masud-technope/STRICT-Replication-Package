//}}}
//{{{ preferred widths
// constrained by left component preferred width
private int getLeftPreferredWidth() {
    if (left != null) {
        return left.getPreferredSize().width;
    }
    int tlw = topLeft == null ? 0 : topLeft.getPreferredSize().width;
    int lw = left == null ? 0 : left.getPreferredSize().width;
    int blw = bottomLeft == null ? 0 : bottomLeft.getPreferredSize().width;
    return Math.max(lw, Math.max(tlw, blw));
}