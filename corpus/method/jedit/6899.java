//}}}
//{{{ preferred heights
// constrained by top component preferred height
private int getTopPreferredHeight() {
    if (top != null) {
        return top.getPreferredSize().height;
    }
    int tlh = topLeft == null ? 0 : topLeft.getPreferredSize().height;
    int th = top == null ? 0 : top.getPreferredSize().height;
    int trh = topRight == null ? 0 : topRight.getPreferredSize().height;
    return Math.max(th, Math.max(tlh, trh));
}