//}}}
//{{{ mouseDragged() method
@Override
public void mouseDragged(MouseEvent evt) {
    if (isPopupTrigger(evt))
        return;
    if (maybeDragAndDrop) {
        textArea.startDragAndDrop(evt, control);
        return;
    }
    if (textArea.getBuffer().isLoading())
        return;
    TextAreaPainter painter = textArea.getPainter();
    if (evt.getY() < 0) {
        int delta = Math.min(-1, evt.getY() / painter.getLineHeight());
        textArea.setFirstLine(textArea.getFirstLine() + delta);
    } else if (evt.getY() >= painter.getHeight()) {
        int delta = Math.max(1, (evt.getY() - painter.getHeight()) / painter.getLineHeight());
        if (textArea.lastLinePartial)
            delta--;
        textArea.setFirstLine(textArea.getFirstLine() + delta);
    }
    switch(clickCount) {
        case 1:
            doSingleDrag(evt);
            break;
        case 2:
            doDoubleDrag(evt);
            break;
        default:
            //case 3:
            doTripleDrag(evt);
            break;
    }
}