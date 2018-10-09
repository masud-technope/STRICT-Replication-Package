@Test
public void read_charArray_int_int_ShouldConvertEscapeSequenceWithThrottledInputStream() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    int c = getThrottledReader("\\u21aF").read(bufferArray, 0, 1);
    assertThat(c, is(equalTo(1)));
    assertThat(bufferArray[0], is(equalTo('?')));
}