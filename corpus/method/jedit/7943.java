@Test
public void read_charArray_int_int_ShouldCorrectlyHandleEOFAfterBackslash() throws IOException {
    int c = getReader("\\").read(bufferArray, 0, 1);
    assertThat(c, is(equalTo(1)));
    assertThat(bufferArray[0], is(equalTo('\\')));
}