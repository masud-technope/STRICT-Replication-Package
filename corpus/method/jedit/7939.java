@Test
public void read_charArray_ShouldCorrectlyHandleEOFAfterBackslash() throws IOException {
    int c = getReader("\\").read(bufferArray);
    assertThat(c, is(equalTo(1)));
    assertThat(bufferArray[0], is(equalTo('\\')));
}