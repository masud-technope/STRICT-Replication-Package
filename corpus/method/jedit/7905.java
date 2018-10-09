@Test
public void read_charArray_int_int_ShouldConvertEscapeSequence() throws IOException {
    int c = getReader("\\u21aF").read(bufferArray, 0, 1);
    assertThat(c, is(equalTo(1)));
    assertThat(bufferArray[0], is(equalTo('?')));
}