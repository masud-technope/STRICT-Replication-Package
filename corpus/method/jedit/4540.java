//}}}
//{{{ implements Encoding
@Nonnull
public Reader getTextReader(@Nonnull InputStream in) throws IOException {
    // CodingErrorAction.REPLACE internally.
    return new InputStreamReader(in, body.newDecoder());
}