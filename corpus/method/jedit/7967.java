@Test
public void readShouldConvertEscapeSequenceThatFollowsTwoBackslashes() throws IOException {
    Reader reader = getReader("\\\\\\u21aF");
    int c = reader.read();
    assertThat((char) c, is(equalTo('\\')));
    c = reader.read();
    assertThat((char) c, is(equalTo('\\')));
    c = reader.read();
    assertThat((char) c, is(equalTo('?')));
    c = reader.read();
    assertThat(c, is(equalTo(-1)));
}