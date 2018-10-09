private Reader getPermissiveReader(String input) throws IOException {
    InputStream inputStream = new ByteArrayInputStream(input.getBytes(iso_8859_1));
    reader = native2ASCIIEncoding.getPermissiveTextReader(inputStream);
    return reader;
}