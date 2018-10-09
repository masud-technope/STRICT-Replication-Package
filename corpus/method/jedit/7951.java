@Test
public void read_CharBuffer_ShouldConvertEscapeSequenceWithThrottledInputStream() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    int c = getThrottledReader("\\u21aF").read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(1)));
    assertThat(buffer.toString(), is(equalTo("?")));
}