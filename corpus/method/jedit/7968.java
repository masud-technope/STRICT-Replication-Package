@Test
public void read_charArray_ShouldConvertEscapeSequenceThatFollowsTwoBackslashes() throws IOException {
    int c = getReader("\\\\\\u21aF").read(bufferArray);
    assertThat(c, is(equalTo(3)));
    int i = 0;
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo('?')));
}