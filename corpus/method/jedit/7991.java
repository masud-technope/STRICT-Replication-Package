@Test
public void skipShouldSkipGivenAmountIfAvailable() throws IOException {
    Reader reader = getReader("asdf\\: \\\\u21alasdf");
    long skipped = reader.skip(8);
    assertThat(skipped, is(equalTo(8L)));
    int c = reader.read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(10)));
    assertThat(buffer.length(), is(equalTo(10)));
    assertThat(buffer.toString(), is(equalTo("\\u21alasdf")));
}