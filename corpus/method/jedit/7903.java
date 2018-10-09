@Test(expected = MalformedInputException.class)
public void readShouldThrowExceptionOnIncompleteEscapeSequence() throws IOException {
    getReader("\\u21a").read();
}