@Test
public void permissiveRead_charArray_int_int_ShouldAcceptMissingInputAfterU() throws IOException {
    Reader reader = getPermissiveReader("\\u");
    int c = reader.read(bufferArray, 0, 2);
    assertThat(c, is(equalTo(2)));
    int i = 0;
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo('u')));
}