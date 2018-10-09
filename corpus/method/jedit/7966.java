@Test
public void read_CharBuffer_ShouldConvertEscapeSequenceThatFollowsTwoBackslashes() throws IOException {
    Reader reader = getReader("\\\\\\u21aF");
    int c = reader.read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(3)));
    assertThat(buffer.length(), is(equalTo(3)));
    assertThat(buffer.toString(), is(equalTo("\\\\?")));
}