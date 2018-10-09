@Test
public void write_String_ShouldEncodeASCIICharactersCorrectly() throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    writer = native2ASCIIEncoding.getTextWriter(baos);
    writer.write("\\u21aF");
    writer.flush();
    assertThat(baos.toString("ISO-8859-1"), is(equalTo("\\u21aF")));
}