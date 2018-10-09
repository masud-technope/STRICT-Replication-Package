@Test
public void read_CharBuffer_ShouldCorrectlyHandleEOF() throws IOException {
    int c = getReader("").read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(-1)));
    assertThat(buffer.length(), is(equalTo(0)));
}