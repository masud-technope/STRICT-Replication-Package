private Reader getReader(String input) throws IOException {
    InputStream inputStream = new ByteArrayInputStream(input.getBytes(iso_8859_1));
    reader = native2ASCIIEncoding.getTextReader(inputStream);
    return reader;
}