//{{{ cellRectIsVisible() method
private boolean cellRectIsVisible(Rectangle cellRect) {
    Rectangle vr = TOCTree.this.getVisibleRect();
    return vr.contains(cellRect.x, cellRect.y) && vr.contains(cellRect.x + cellRect.width, cellRect.y + cellRect.height);
//}}}
}