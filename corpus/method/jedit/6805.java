//{{{ mouseReleased() method
public void mouseReleased(MouseEvent e) {
    if (drag && e.getX() >= getWidth() - borderWidth * 2) {
        e.translatePoint(-getWidth(), 0);
        textArea.mouseHandler.mouseReleased(e);
    }
    if (selectLines) {
        Selection sel = textArea.getSelectionAtOffset(selectionStart);
        if (sel != null)
            Registers.setRegister('%', textArea.getSelectedText(sel));
    }
    drag = false;
    selectLines = false;
//}}}
}