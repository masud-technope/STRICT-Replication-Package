//{{{ setResizePos() method
void setResizePos(int resizePos, PanelWindowContainer resizing) {
    this.resizePos = resizePos;
    if (resizePos < 0)
        resizePos = 0;
    if (continuousLayout)
        return;
    Rectangle newResizeRect = new Rectangle(0, 0, PanelWindowContainer.SPLITTER_WIDTH - 2, PanelWindowContainer.SPLITTER_WIDTH - 2);
    if (resizing == top) {
        resizePos = Math.min(resizePos, getHeight() - top.buttonPanel.getHeight() - bottom.dockablePanel.getHeight() - bottom.buttonPanel.getHeight() - PanelWindowContainer.SPLITTER_WIDTH);
        newResizeRect.x = top.dockablePanel.getX() + 1;
        newResizeRect.y = resizePos + top.buttonPanel.getHeight() + 1;
        newResizeRect.width = top.dockablePanel.getWidth() - 2;
    } else if (resizing == left) {
        resizePos = Math.min(resizePos, getWidth() - left.buttonPanel.getWidth() - right.dockablePanel.getWidth() - right.buttonPanel.getWidth() - PanelWindowContainer.SPLITTER_WIDTH);
        newResizeRect.x = resizePos + left.buttonPanel.getWidth() + 1;
        newResizeRect.y = left.dockablePanel.getY() + 1;
        newResizeRect.height = left.dockablePanel.getHeight() - 2;
    } else if (resizing == bottom) {
        resizePos = Math.min(resizePos, getHeight() - bottom.buttonPanel.getHeight() - top.dockablePanel.getHeight() - top.buttonPanel.getHeight() - PanelWindowContainer.SPLITTER_WIDTH);
        newResizeRect.x = bottom.dockablePanel.getX() + 1;
        newResizeRect.y = getHeight() - bottom.buttonPanel.getHeight() - resizePos - PanelWindowContainer.SPLITTER_WIDTH + 2;
        newResizeRect.width = bottom.dockablePanel.getWidth() - 2;
    } else if (resizing == right) {
        resizePos = Math.min(resizePos, getWidth() - right.buttonPanel.getWidth() - left.dockablePanel.getWidth() - left.buttonPanel.getWidth() - PanelWindowContainer.SPLITTER_WIDTH);
        newResizeRect.x = getWidth() - right.buttonPanel.getWidth() - resizePos - PanelWindowContainer.SPLITTER_WIDTH + 1;
        newResizeRect.y = right.dockablePanel.getY() + 1;
        newResizeRect.height = right.dockablePanel.getHeight() - 2;
    }
    Rectangle toRepaint;
    if (resizeRect == null)
        toRepaint = newResizeRect;
    else
        toRepaint = resizeRect.union(newResizeRect);
    resizeRect = newResizeRect;
    repaint(toRepaint);
}