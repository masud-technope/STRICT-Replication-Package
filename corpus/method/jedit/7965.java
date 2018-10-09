@Test
public void read_charArray_int_int_ShouldConvertEscapeSequenceThatFollowsTwoBackslashes() throws IOException {
    int c = getReader("\\\\\\u21aF").read(bufferArray, 0, 3);
    assertThat(c, is(equalTo(3)));
    int i = 0;
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo('?')));
}