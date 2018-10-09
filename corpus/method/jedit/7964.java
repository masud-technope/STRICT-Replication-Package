@Test
public void read_CharBuffer_ShouldReadBackslashWithoutFollowingUAsBackslash() throws IOException {
    String input = "\\nu21aF";
    Reader reader = getReader(input);
    int c = reader.read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(7)));
    assertThat(buffer.length(), is(equalTo(7)));
    assertThat(buffer.toString(), is(equalTo(input)));
}