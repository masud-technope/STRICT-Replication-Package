public AttributedCharacterIterator cancelLatestCommittedText(AttributedCharacterIterator.Attribute[] attributes) {
    if (lastCommittedText != null) {
        int offset = lastCommittedAt;
        int length = lastCommittedText.length();
        String sample = owner.getText(offset, length);
        if (sample != null && sample.equals(lastCommittedText)) {
            AttributedCharacterIterator canceled = (new AttributedString(sample)).getIterator();
            owner.getBuffer().remove(offset, length);
            owner.setCaretPosition(offset);
            lastCommittedText = null;
            return canceled;
        }
        // Cleare last committed information to prevent
        // accidental match.
        lastCommittedText = null;
    }
    return null;
}