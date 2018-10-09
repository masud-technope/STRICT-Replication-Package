// }}}
// {{{ implements InputMethodListener
public void inputMethodTextChanged(InputMethodEvent event) {
    composedTextLayout = null;
    AttributedCharacterIterator text = event.getText();
    if (text != null) {
        int committed_count = event.getCommittedCharacterCount();
        if (committed_count > 0) {
            lastCommittedText = null;
            lastCommittedAt = owner.getCaretPosition();
            StringBuilder committed = new StringBuilder(committed_count);
            char c;
            int count;
            for (c = text.first(), count = committed_count; c != AttributedCharacterIterator.DONE && count > 0; c = text.next(), --count) {
                owner.userInput(c);
                committed.append(c);
            }
            lastCommittedText = committed.toString();
        }
        int end_index = text.getEndIndex();
        if (committed_count < end_index) {
            AttributedString composed = new AttributedString(text, committed_count, end_index);
            TextAreaPainter painter = owner.getPainter();
            composed.addAttribute(TextAttribute.FONT, painter.getFont());
            composedTextLayout = new TextLayout(composed.getIterator(), painter.getFontRenderContext());
        }
    }
    // Also updates caret.
    caretPositionChanged(event);
}