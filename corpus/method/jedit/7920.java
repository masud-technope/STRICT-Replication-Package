@Test(expected = MalformedInputException.class)
public void read_CharBuffer_ShouldThrowExceptionOnMissingInputAfterU() throws IOException {
    getReader("\\u").read(buffer);
}