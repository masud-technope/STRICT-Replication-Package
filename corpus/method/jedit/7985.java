@Test
public void readerShouldBeAbleToDecodeWhatWriterHasEncoded() throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    writer = native2ASCIIEncoding.getTextWriter(baos);
    writer.write('?');
    writer.flush();
    assertThat(baos.toString("ISO-8859-1"), is(equalTo("\\u21AF")));
    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
    reader = native2ASCIIEncoding.getTextReader(bais);
    int c = reader.read();
    assertThat((char) c, is(equalTo('?')));
    c = reader.read();
    assertThat(c, is(equalTo(-1)));
}