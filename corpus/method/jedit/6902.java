//}}}
//{{{ minimumLayoutSize() method
public Dimension minimumLayoutSize(Container parent) {
    Dimension dim = new Dimension();
    Insets insets = getInsets(parent);
    dim.width = insets.left + insets.right;
    dim.height = insets.top + insets.bottom;
    int tlw = topLeft == null ? 0 : topLeft.getMinimumSize().width;
    int lw = left == null ? 0 : left.getMinimumSize().width;
    int blw = bottomLeft == null ? 0 : bottomLeft.getMinimumSize().width;
    dim.width += Math.max(lw, Math.max(tlw, blw));
    int tw = top == null ? 0 : top.getMinimumSize().width;
    int cw = center == null ? 0 : center.getMinimumSize().width;
    int bw = bottom == null ? 0 : bottom.getMinimumSize().width;
    dim.width += Math.max(cw, Math.max(tw, bw));
    int trw = topRight == null ? 0 : topRight.getMinimumSize().width;
    int rw = right == null ? 0 : right.getMinimumSize().width;
    int brw = bottomRight == null ? 0 : bottomRight.getMinimumSize().width;
    dim.width += Math.max(rw, Math.max(trw, brw));
    int tlh = topLeft == null ? 0 : topLeft.getMinimumSize().height;
    int lh = left == null ? 0 : left.getMinimumSize().height;
    int blh = bottomLeft == null ? 0 : bottomLeft.getMinimumSize().height;
    dim.height += Math.max(lh, Math.max(tlh, blh));
    int th = top == null ? 0 : top.getMinimumSize().height;
    int ch = center == null ? 0 : center.getMinimumSize().height;
    int bh = bottom == null ? 0 : bottom.getMinimumSize().height;
    dim.height += Math.max(ch, Math.max(th, bh));
    int trh = topRight == null ? 0 : topRight.getMinimumSize().height;
    int rh = right == null ? 0 : right.getMinimumSize().height;
    int brh = bottomRight == null ? 0 : bottomRight.getMinimumSize().height;
    dim.height += Math.max(rh, Math.max(trh, brh));
    return dim;
}