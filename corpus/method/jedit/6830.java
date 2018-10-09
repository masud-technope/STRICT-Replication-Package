public AttributedCharacterIterator getCommittedText(int beginIndex, int endIndex, AttributedCharacterIterator.Attribute[] attributes) {
    return (new AttributedString(owner.getText(beginIndex, endIndex - beginIndex))).getIterator();
}