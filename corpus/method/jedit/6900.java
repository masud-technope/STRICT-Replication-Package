private int getCenterPreferredHeight() {
    int lh = left == null ? 0 : left.getPreferredSize().height;
    int ch = center == null ? 0 : center.getPreferredSize().height;
    int rh = right == null ? 0 : right.getPreferredSize().height;
    return Math.max(ch, Math.max(lh, rh));
}