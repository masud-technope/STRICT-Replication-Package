//}}}
//{{{ mousePressed() method
@Override
public void mousePressed(MouseEvent evt) {
    showCursor();
    int btn = evt.getButton();
    if (btn != MouseEvent.BUTTON1 && btn != MouseEvent.BUTTON2 && btn != MouseEvent.BUTTON3) {
        // problems due to horizontal scrolling.
        return;
    }
    control = (OperatingSystem.isMacOS() && evt.isMetaDown()) || (!OperatingSystem.isMacOS() && evt.isControlDown());
    ctrlForRectangularSelection = textArea.isCtrlForRectangularSelection();
    // so that Home <mouse click> Home is not the same
    // as pressing Home twice in a row
    textArea.getInputHandler().resetLastActionCount();
    quickCopyDrag = (textArea.isQuickCopyEnabled() && isMiddleButton(evt.getModifiersEx()));
    if (!quickCopyDrag) {
        textArea.requestFocus();
        TextArea.focusedComponent = textArea;
    }
    if (textArea.getBuffer().isLoading())
        return;
    int x = evt.getX();
    int y = evt.getY();
    dragStart = textArea.xyToOffset(x, y, !(textArea.getPainter().isBlockCaretEnabled() || textArea.isOverwriteEnabled()));
    dragStartLine = textArea.getLineOfOffset(dragStart);
    dragStartOffset = dragStart - textArea.getLineStartOffset(dragStartLine);
    if (isPopupTrigger(evt) && textArea.getRightClickPopup() != null) {
        if (textArea.isRightClickPopupEnabled())
            textArea.handlePopupTrigger(evt);
        return;
    }
    dragged = false;
    textArea.blink = true;
    textArea.invalidateLine(textArea.getCaretLine());
    clickCount = evt.getClickCount();
    if (textArea.isDragEnabled() && textArea.selectionManager.insideSelection(x, y) && clickCount == 1 && !evt.isShiftDown()) {
        maybeDragAndDrop = true;
        textArea.moveCaretPosition(dragStart, false);
        return;
    }
    maybeDragAndDrop = false;
    if (quickCopyDrag) {
        // ignore double clicks of middle button
        doSingleClick(evt);
    } else {
        switch(clickCount) {
            case 1:
                doSingleClick(evt);
                break;
            case 2:
                doDoubleClick();
                break;
            //case 3:
            default:
                doTripleClick();
                break;
        }
    }
}