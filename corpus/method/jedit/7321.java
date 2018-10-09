//}}}
//{{{ mouseReleased() method
@Override
public void mouseReleased(MouseEvent evt) {
    int btn = evt.getButton();
    if (btn != MouseEvent.BUTTON1 && btn != MouseEvent.BUTTON2 && btn != MouseEvent.BUTTON3) {
        // problems due to horizontal scrolling.
        return;
    }
    // middle mouse button drag inserts selection
    // at caret position
    Selection sel = textArea.getSelectionAtOffset(dragStart);
    if (dragged && sel != null) {
        Registers.setRegister('%', textArea.getSelectedText(sel));
        if (quickCopyDrag) {
            textArea.removeFromSelection(sel);
            Registers.paste(TextArea.focusedComponent, '%', sel instanceof Selection.Rect);
            TextArea.focusedComponent.requestFocus();
        }
    } else if (!dragged && textArea.isQuickCopyEnabled() && isMiddleButton(evt.getModifiersEx())) {
        textArea.requestFocus();
        TextArea.focusedComponent = textArea;
        textArea.setCaretPosition(dragStart, false);
        if (!textArea.isEditable())
            textArea.getToolkit().beep();
        else
            Registers.paste(textArea, '%', control);
    } else if (maybeDragAndDrop && !textArea.isMultipleSelectionEnabled()) {
        textArea.selectNone();
    }
    maybeDragAndDrop = false;
    dragged = false;
    if (!(textArea.isRectangularSelectionEnabled() || (control && ctrlForRectangularSelection)))
        // avoid scrolling away from rectangular selection
        textArea.scrollToCaret(false);
}