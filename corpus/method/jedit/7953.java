@Test
public void read_charArray_ShouldConvertEscapeSequenceWithThrottledInputStream() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    int c = getThrottledReader("\\u21aF").read(bufferArray);
    assertThat(c, is(equalTo(1)));
    assertThat(bufferArray[0], is(equalTo('?')));
}