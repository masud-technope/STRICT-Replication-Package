@Test
public void write_charArray_ShouldEncodeNonASCIICharactersCorrectly() throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    writer = native2ASCIIEncoding.getTextWriter(baos);
    writer.write(new char[] { '?' });
    writer.flush();
    assertThat(baos.toString("ISO-8859-1"), is(equalTo("\\u21AF")));
}