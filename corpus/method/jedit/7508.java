@Override
public void scrolledVertically(TextArea textArea) {
    if (getTextArea() == textArea)
        status.updateCaretStatus();
}