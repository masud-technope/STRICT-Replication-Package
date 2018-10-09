@Test(expected = IllegalArgumentException.class)
public void skipShouldThrowExceptionIfToSkipIsNegative() throws IOException {
    getReader("asdf\\: \\\\u21alasdf").skip(-1);
}