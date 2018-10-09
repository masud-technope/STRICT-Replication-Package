@Test
public void read_charArray_int_int_ShouldIgnoreEscapeSequenceThatFollowsOneBackslash() throws IOException {
    int c = getReader("\\\\u21aF").read(bufferArray, 0, 7);
    assertThat(c, is(equalTo(7)));
    int i = 0;
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo('u')));
    assertThat(bufferArray[i++], is(equalTo('2')));
    assertThat(bufferArray[i++], is(equalTo('1')));
    assertThat(bufferArray[i++], is(equalTo('a')));
    assertThat(bufferArray[i++], is(equalTo('F')));
}