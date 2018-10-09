@Test(expected = MalformedInputException.class)
public void read_CharBuffer_ShouldThrowExceptionOnIncompleteEscapeSequence() throws IOException {
    getReader("\\u21a").read(buffer);
}