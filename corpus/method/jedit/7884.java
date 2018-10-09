@Test
public void append_CharSequence_int_int_ShouldEncodeNullCorrectly() throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    writer = native2ASCIIEncoding.getTextWriter(baos);
    Writer returnedWriter = writer.append(null, 0, 4);
    writer.flush();
    assertThat(returnedWriter, is(sameInstance(writer)));
    assertThat(baos.toString("ISO-8859-1"), is(equalTo("null")));
}