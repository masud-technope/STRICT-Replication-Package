@Test
public void readShouldCorrectlyHandleLessThan5NonEscapeCharactersAfterBackslash() throws IOException {
    Reader reader = getReader("\\asdf");
    int c = reader.read();
    assertThat((char) c, is(equalTo('\\')));
    c = reader.read();
    assertThat((char) c, is(equalTo('a')));
    c = reader.read();
    assertThat((char) c, is(equalTo('s')));
    c = reader.read();
    assertThat((char) c, is(equalTo('d')));
    c = reader.read();
    assertThat((char) c, is(equalTo('f')));
    c = reader.read();
    assertThat(c, is(equalTo(-1)));
}