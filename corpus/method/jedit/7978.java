@Test
public void read_CharBuffer_ShouldIgnoreIncompleteEscapeSequenceThatFollowsOneBackslash() throws IOException {
    String input = "\\\\u21a";
    Reader reader = getReader(input);
    int c = reader.read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(6)));
    assertThat(buffer.length(), is(equalTo(6)));
    assertThat(buffer.toString(), is(equalTo(input)));
}