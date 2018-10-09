@Test
public void write_charArray_ShouldEncodeASCIICharactersCorrectly() throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    writer = native2ASCIIEncoding.getTextWriter(baos);
    writer.write(new char[] { '\\', 'u', '2', '1', 'a', 'F' });
    writer.flush();
    assertThat(baos.toString("ISO-8859-1"), is(equalTo("\\u21aF")));
}