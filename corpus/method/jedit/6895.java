// constrained by right component preferred width
private int getRightPreferredWidth() {
    if (right != null) {
        return right.getPreferredSize().width;
    }
    int trw = topRight == null ? 0 : topRight.getPreferredSize().width;
    int rw = right == null ? 0 : right.getPreferredSize().width;
    int brw = bottomRight == null ? 0 : bottomRight.getPreferredSize().width;
    return Math.max(rw, Math.max(trw, brw));
}