@Test(expected = MalformedInputException.class)
public void read_charArray_int_int_ShouldThrowExceptionOnMissingInputAfterU() throws IOException {
    getReader("\\u").read(bufferArray, 0, 1);
}