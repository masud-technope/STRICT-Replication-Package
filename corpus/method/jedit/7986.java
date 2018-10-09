@Test
public void readerShouldReadSingleCharactersIfWriterAddedAnEscapingBackslash() throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    writer = native2ASCIIEncoding.getTextWriter(baos);
    writer.write('\\');
    writer.write('?');
    writer.flush();
    assertThat(baos.toString("ISO-8859-1"), is(equalTo("\\\\u21AF")));
    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
    reader = native2ASCIIEncoding.getTextReader(bais);
    int c = reader.read();
    assertThat((char) c, is(equalTo('\\')));
    c = reader.read();
    assertThat((char) c, is(equalTo('\\')));
    c = reader.read();
    assertThat((char) c, is(equalTo('u')));
    c = reader.read();
    assertThat((char) c, is(equalTo('2')));
    c = reader.read();
    assertThat((char) c, is(equalTo('1')));
    c = reader.read();
    assertThat((char) c, is(equalTo('A')));
    c = reader.read();
    assertThat((char) c, is(equalTo('F')));
    c = reader.read();
    assertThat(c, is(equalTo(-1)));
}