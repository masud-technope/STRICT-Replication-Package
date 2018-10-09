@Test
public void read_charArray_int_int_ShouldIgnoreMalformedEscapeSequenceThatFollowsOneBackslash() throws IOException {
    int c = getReader("asdf\\: \\\\u21alasdf").read(bufferArray, 0, 18);
    assertThat(c, is(equalTo(18)));
    int i = 0;
    assertThat(bufferArray[i++], is(equalTo('a')));
    assertThat(bufferArray[i++], is(equalTo('s')));
    assertThat(bufferArray[i++], is(equalTo('d')));
    assertThat(bufferArray[i++], is(equalTo('f')));
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo(':')));
    assertThat(bufferArray[i++], is(equalTo(' ')));
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo('u')));
    assertThat(bufferArray[i++], is(equalTo('2')));
    assertThat(bufferArray[i++], is(equalTo('1')));
    assertThat(bufferArray[i++], is(equalTo('a')));
    assertThat(bufferArray[i++], is(equalTo('l')));
    assertThat(bufferArray[i++], is(equalTo('a')));
    assertThat(bufferArray[i++], is(equalTo('s')));
    assertThat(bufferArray[i++], is(equalTo('d')));
    assertThat(bufferArray[i++], is(equalTo('f')));
}