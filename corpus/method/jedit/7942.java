@Test
public void read_charArray_ShouldCorrectlyHandleLessThan5NonEscapeCharactersAfterBackslash() throws IOException {
    int c = getReader("\\asdf").read(bufferArray);
    assertThat(c, is(equalTo(5)));
    int i = 0;
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo('a')));
    assertThat(bufferArray[i++], is(equalTo('s')));
    assertThat(bufferArray[i++], is(equalTo('d')));
    assertThat(bufferArray[i++], is(equalTo('f')));
}