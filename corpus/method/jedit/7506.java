@Override
public void caretUpdate(CaretEvent evt) {
    if (evt.getSource() == getTextArea())
        status.updateCaretStatus();
}