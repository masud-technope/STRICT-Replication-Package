@Test(expected = MalformedInputException.class)
public void read_charArray_int_int_ShouldThrowExceptionOnMalformedInput() throws IOException {
    getReader("asdf\\: \\u21alasdf").read(bufferArray, 0, 15);
}