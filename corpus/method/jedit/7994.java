@Test
public void skipShouldNotDoAnythingIfToSkipIsZero() throws IOException {
    String input = "asdf\\: \\\\u21alasdf";
    Reader reader = getReader(input);
    long skipped = reader.skip(0);
    assertThat(skipped, is(equalTo(0L)));
    int c = reader.read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(18)));
    assertThat(buffer.length(), is(equalTo(18)));
    assertThat(buffer.toString(), is(equalTo(input)));
}