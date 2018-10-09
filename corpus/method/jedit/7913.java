@Test
public void readShouldConvertEscapeSequence() throws IOException {
    int c = getReader("\\u21aF").read();
    assertThat((char) c, is(equalTo('?')));
}