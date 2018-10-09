//}}}
//{{{ implements Encoding
@Nonnull
public Reader getTextReader(@Nonnull InputStream in) throws IOException {
    byte[] actualMark = new byte[bom.length];
    int count = in.read(actualMark);
    if (count < bom.length || !Arrays.equals(actualMark, bom)) {
        throw new MalformedInputException(0);
    }
    return plain.getTextReader(in);
}