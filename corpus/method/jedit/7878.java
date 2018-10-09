@Test
public void append_CharSequence_ShouldEncodeNonASCIICharactersCorrectly() throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    writer = native2ASCIIEncoding.getTextWriter(baos);
    Writer returnedWriter = writer.append("?");
    writer.flush();
    assertThat(returnedWriter, is(sameInstance(writer)));
    assertThat(baos.toString("ISO-8859-1"), is(equalTo("\\u21AF")));
}