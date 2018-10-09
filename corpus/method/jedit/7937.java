@Test
public void read_CharBuffer_ShouldCorrectlyHandleLessThan5NonEscapeCharactersAfterBackslash() throws IOException {
    String input = "\\asdf";
    int c = getReader(input).read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(5)));
    assertThat(buffer.length(), is(equalTo(5)));
    assertThat(buffer.toString(), is(equalTo(input)));
}