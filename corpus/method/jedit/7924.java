@Test(expected = MalformedInputException.class)
public void read_charArray_ShouldThrowExceptionOnMalformedInput() throws IOException {
    getReader("asdf\\: \\u21alasdf").read(bufferArray);
}