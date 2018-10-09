@Test(expected = MalformedInputException.class)
public void read_charArray_ShouldThrowExceptionOnMissingInputAfterU() throws IOException {
    getReader("\\u").read(bufferArray);
}