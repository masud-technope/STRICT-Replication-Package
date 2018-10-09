@Test
public void permissiveReadShouldAcceptMissingInputAfterU() throws IOException {
    Reader reader = getPermissiveReader("\\u");
    int c = reader.read();
    assertThat((char) c, is(equalTo('\\')));
    c = reader.read();
    assertThat((char) c, is(equalTo('u')));
    c = reader.read();
    assertThat(c, is(equalTo(-1)));
}