@Test
public void readShouldCorrectlyHandleEOFAfterBackslash() throws IOException {
    Reader reader = getReader("\\");
    int c = reader.read();
    assertThat((char) c, is(equalTo('\\')));
    c = reader.read();
    assertThat(c, is(equalTo(-1)));
}