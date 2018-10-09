@Test
public void read_charArray_ShouldConvertEscapeSequence() throws IOException {
    int c = getReader("\\u21aF").read(bufferArray);
    assertThat(c, is(equalTo(1)));
    assertThat(bufferArray[0], is(equalTo('?')));
}