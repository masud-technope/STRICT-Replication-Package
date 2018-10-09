@Test
public void readShouldConvertEscapeSequenceWithThrottledInputStream() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    int c = getThrottledReader("\\u21aF").read();
    assertThat((char) c, is(equalTo('?')));
}