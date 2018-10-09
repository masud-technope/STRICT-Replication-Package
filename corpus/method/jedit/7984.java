@Test
public void read_CharBuffer_ShouldIgnoreEscapeSequenceThatFollowsThreeBackslashes() throws IOException {
    String input = "\\\\\\\\u21aF";
    Reader reader = getReader(input);
    int c = reader.read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(9)));
    assertThat(buffer.length(), is(equalTo(9)));
    assertThat(buffer.toString(), is(equalTo(input)));
}