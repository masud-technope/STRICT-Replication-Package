private int getCenterPreferredWidth() {
    int tw = top == null ? 0 : top.getPreferredSize().width;
    int cw = center == null ? 0 : center.getPreferredSize().width;
    int bw = bottom == null ? 0 : bottom.getPreferredSize().width;
    return Math.max(cw, Math.max(tw, bw));
}