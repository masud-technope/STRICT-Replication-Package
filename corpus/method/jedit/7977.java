@Test
public void read_charArray_int_int_ShouldIgnoreIncompleteEscapeSequenceThatFollowsOneBackslash() throws IOException {
    int c = getReader("\\\\u21a").read(bufferArray, 0, 6);
    assertThat(c, is(equalTo(6)));
    int i = 0;
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo('u')));
    assertThat(bufferArray[i++], is(equalTo('2')));
    assertThat(bufferArray[i++], is(equalTo('1')));
    assertThat(bufferArray[i++], is(equalTo('a')));
}