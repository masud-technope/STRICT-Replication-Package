@Test
public void permissiveRead_CharBuffer_ShouldAcceptIncompleteEscapeSequence() throws IOException {
    String input = "\\u21a";
    Reader reader = getPermissiveReader(input);
    int c = reader.read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(5)));
    assertThat(buffer.length(), is(equalTo(5)));
    assertThat(buffer.toString(), is(equalTo(input)));
}