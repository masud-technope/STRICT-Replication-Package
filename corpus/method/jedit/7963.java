@Test
public void read_charArray_int_int_shouldReadOnAfterCollapsingEscapeSequences() throws IOException {
    int c = getReader("asdf\\: \\u21aFasdf").read(bufferArray, 0, 12);
    assertThat(c, is(equalTo(12)));
    int i = 0;
    assertThat(bufferArray[i++], is(equalTo('a')));
    assertThat(bufferArray[i++], is(equalTo('s')));
    assertThat(bufferArray[i++], is(equalTo('d')));
    assertThat(bufferArray[i++], is(equalTo('f')));
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo(':')));
    assertThat(bufferArray[i++], is(equalTo(' ')));
    assertThat(bufferArray[i++], is(equalTo('?')));
    assertThat(bufferArray[i++], is(equalTo('a')));
    assertThat(bufferArray[i++], is(equalTo('s')));
    assertThat(bufferArray[i++], is(equalTo('d')));
    assertThat(bufferArray[i++], is(equalTo('f')));
}