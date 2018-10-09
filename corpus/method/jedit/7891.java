@Test(expected = MalformedInputException.class)
public void readShouldThrowExceptionOnMissingInputAfterU() throws IOException {
    getReader("\\u").read();
}