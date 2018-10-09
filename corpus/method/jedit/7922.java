@Test(expected = MalformedInputException.class)
public void read_CharBuffer_ShouldThrowExceptionOnMalformedInput() throws IOException {
    getReader("asdf\\: \\u21alasdf").read(buffer);
}