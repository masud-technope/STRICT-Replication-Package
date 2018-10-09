@Test
public void skipShouldSkipAllIfToSkipIsGreaterThanInputLength() throws IOException {
    Reader reader = getReader("asdf\\: \\\\u21alasdf");
    long skipped = reader.skip(20);
    assertThat(skipped, is(equalTo(18L)));
    int c = reader.read();
    assertThat(c, is(equalTo(-1)));
}