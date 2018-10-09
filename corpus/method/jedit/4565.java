@Nonnull
public Reader getPermissiveTextReader(@Nonnull InputStream in) throws IOException {
    byte[] actualMark = new byte[bom.length];
    int count = in.read(actualMark);
    if (count < bom.length || !Arrays.equals(actualMark, bom)) {
        // Concatenate the non-BOM bytes and the rest of
        // input so that the non-BOM bytes are reinterepreted
        // as some characters.
        in = new SequenceInputStream(new ByteArrayInputStream(actualMark, 0, count), in);
    }
    return plain.getPermissiveTextReader(in);
}