@Test
public void read_CharBuffer_shouldReadOnAfterCollapsingEscapeSequences() throws IOException {
    int c = getReader("asdf\\: \\u21aFasdf").read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(12)));
    assertThat(buffer.length(), is(equalTo(12)));
    assertThat(buffer.toString(), is(equalTo("asdf\\: ?asdf")));
}