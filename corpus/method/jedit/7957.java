@Test
public void permissiveRead_CharBuffer_ShouldAcceptMalformedInputWithThrottledReader() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    String input = "\\u21a;";
    Reader reader = getThrottledPermissiveReader(input);
    int c = reader.read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(6)));
    assertThat(buffer.length(), is(equalTo(6)));
    assertThat(buffer.toString(), is(equalTo(input)));
}