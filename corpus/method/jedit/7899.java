@Test
public void append_char_ShouldEncodeASCIICharactersCorrectly() throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    writer = native2ASCIIEncoding.getTextWriter(baos);
    Writer returnedWriter = writer.append('\\').append('u').append('2').append('1').append('a').append('F');
    writer.flush();
    assertThat(returnedWriter, is(sameInstance(writer)));
    assertThat(baos.toString("ISO-8859-1"), is(equalTo("\\u21aF")));
}