@Test
public void permissiveRead_charArray_ShouldAcceptMissingInputAfterU() throws IOException {
    Reader reader = getPermissiveReader("\\u");
    int c = reader.read(bufferArray);
    assertThat(c, is(equalTo(2)));
    int i = 0;
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo('u')));
}