public  LineCharacterBreaker(TextArea textArea, int offset) {
    final int line = textArea.getLineOfOffset(offset);
    charBreaker = BreakIterator.getCharacterInstance();
    charBreaker.setText(new CharIterator(textArea.buffer.getLineSegment(line)));
    index0Offset = textArea.getLineStartOffset(line);
}