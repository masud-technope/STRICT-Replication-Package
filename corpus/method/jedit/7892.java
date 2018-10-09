@Test(expected = MalformedInputException.class)
public void read_charArray_ShouldThrowExceptionOnIncompleteEscapeSequence() throws IOException {
    getReader("\\u21a").read(bufferArray);
}