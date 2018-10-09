@Test
public void permissiveRead_charArray_ShouldAcceptIncompleteEscapeSequence() throws IOException {
    Reader reader = getPermissiveReader("\\u21a");
    int c = reader.read(bufferArray);
    assertThat(c, is(equalTo(5)));
    int i = 0;
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo('u')));
    assertThat(bufferArray[i++], is(equalTo('2')));
    assertThat(bufferArray[i++], is(equalTo('1')));
    assertThat(bufferArray[i++], is(equalTo('a')));
}