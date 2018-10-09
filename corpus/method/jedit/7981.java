@Test
public void read_CharBuffer_ShouldIgnoreMalformedEscapeSequenceThatFollowsOneBackslash() throws IOException {
    String input = "asdf\\: \\\\u21alasdf";
    Reader reader = getReader(input);
    int c = reader.read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(18)));
    assertThat(buffer.length(), is(equalTo(18)));
    assertThat(buffer.toString(), is(equalTo(input)));
}