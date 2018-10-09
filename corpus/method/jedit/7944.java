@Test
public void read_CharBuffer_ShouldCorrectlyHandleEOFAfterBackslash() throws IOException {
    String input = "\\";
    int c = getReader(input).read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(1)));
    assertThat(buffer.length(), is(equalTo(1)));
    assertThat(buffer.toString(), is(equalTo(input)));
}