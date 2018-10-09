@Test
public void permissiveRead_CharBuffer_ShouldAcceptMalformedInput() throws IOException {
    String input = "asdf\\: \\u21a/asdf";
    Reader reader = getPermissiveReader(input);
    int c = reader.read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(17)));
    assertThat(buffer.length(), is(equalTo(17)));
    assertThat(buffer.toString(), is(equalTo(input)));
}