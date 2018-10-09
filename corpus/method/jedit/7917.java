private Reader getThrottledReader(String input) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
    InputStream inputStream = new ByteArrayInputStream(input.getBytes(iso_8859_1));
    reader = native2ASCIIEncoding.getTextReader(inputStream, ThrottledPushbackReader.class);
    return reader;
}