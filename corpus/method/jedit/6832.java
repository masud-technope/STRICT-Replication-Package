public AttributedCharacterIterator getSelectedText(AttributedCharacterIterator.Attribute[] attributes) {
    Selection selection_on_caret = owner.getSelectionAtOffset(owner.getCaretPosition());
    if (selection_on_caret != null) {
        return (new AttributedString(owner.getSelectedText(selection_on_caret))).getIterator();
    }
    return null;
}