@Test(expected = MalformedInputException.class)
public void readShouldThrowExceptionOnMalformedInput() throws IOException {
    Reader reader = getReader("asdf\\: \\u21alasdf");
    while (reader.read() != -1) {
    }
}