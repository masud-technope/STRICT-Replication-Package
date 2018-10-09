// constrained by bottom component preferred height
private int getBottomPreferredHeight() {
    if (bottom != null) {
        return bottom.getPreferredSize().height;
    }
    int blh = bottomLeft == null ? 0 : bottomLeft.getPreferredSize().height;
    int bh = bottom == null ? 0 : bottom.getPreferredSize().height;
    int brh = bottomRight == null ? 0 : bottomRight.getPreferredSize().height;
    return Math.max(bh, Math.max(brh, blh));
}