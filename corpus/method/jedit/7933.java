@Test
public void permissiveRead_CharBuffer_ShouldAcceptMissingInputAfterU() throws IOException {
    String input = "\\u";
    Reader reader = getPermissiveReader(input);
    int c = reader.read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(2)));
    assertThat(buffer.length(), is(equalTo(2)));
    assertThat(buffer.toString(), is(equalTo(input)));
}