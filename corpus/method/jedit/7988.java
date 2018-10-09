@Test
public void textReaderWithNullAsClassParameterShouldWork() throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
    InputStream inputStream = new ByteArrayInputStream("asdf\\: \\\\u21alasdf".getBytes(iso_8859_1));
    reader = native2ASCIIEncoding.getTextReader(inputStream, null);
    long skipped = reader.skip(18);
    assertThat(skipped, is(equalTo(18L)));
    int c = reader.read();
    assertThat(c, is(equalTo(-1)));
}