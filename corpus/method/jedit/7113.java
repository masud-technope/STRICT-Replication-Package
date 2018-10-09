//}}}
//{{{ deleteNextCharacter() method
// Delete a code point or combining character sequence at once.
private void deleteNextCharacter(int offset) {
    assert offset < buffer.getLength();
    int length = getNextCharacterOffset(offset) - offset;
    buffer.remove(offset, length);
}