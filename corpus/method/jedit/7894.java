@Test(expected = MalformedInputException.class)
public void read_charArray_int_int_ShouldThrowExceptionOnIncompleteEscapeSequence() throws IOException {
    getReader("\\u21a").read(bufferArray, 0, 1);
}