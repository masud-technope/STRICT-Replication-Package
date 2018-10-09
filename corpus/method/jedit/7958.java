@Test
public void permissiveReadShouldAcceptMalformedInputWithThrottledReader() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    Reader reader = getThrottledPermissiveReader("\\u21a;");
    int c = reader.read();
    assertThat((char) c, is(equalTo('\\')));
    c = reader.read();
    assertThat((char) c, is(equalTo('u')));
    c = reader.read();
    assertThat((char) c, is(equalTo('2')));
    c = reader.read();
    assertThat((char) c, is(equalTo('1')));
    c = reader.read();
    assertThat((char) c, is(equalTo('a')));
    c = reader.read();
    assertThat((char) c, is(equalTo(';')));
    c = reader.read();
    assertThat(c, is(equalTo(-1)));
}