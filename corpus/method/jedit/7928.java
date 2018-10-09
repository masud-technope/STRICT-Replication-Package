@Test
public void readShouldCorrectlyHandleEOF() throws IOException {
    int c = getReader("").read();
    assertThat(c, is(equalTo(-1)));
}