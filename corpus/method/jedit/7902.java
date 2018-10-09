@Test
public void read_CharBuffer_ShouldConvertEscapeSequence() throws IOException {
    int c = getReader("\\u21aF").read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(1)));
    assertThat(buffer.length(), is(equalTo(1)));
    assertThat(buffer.toString(), is(equalTo("?")));
}