@Test
public void read_charArray_ShouldCorrectlyHandleEOF() throws IOException {
    int c = getReader("").read(bufferArray);
    assertThat(c, is(equalTo(-1)));
}