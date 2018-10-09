@Test
public void write_String_int_int_ShouldEncodeNonASCIICharactersCorrectly() throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    writer = native2ASCIIEncoding.getTextWriter(baos);
    writer.write("?", 0, 1);
    writer.flush();
    assertThat(baos.toString("ISO-8859-1"), is(equalTo("\\u21AF")));
}