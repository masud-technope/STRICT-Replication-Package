@Nonnull
public Writer getTextWriter(@Nonnull OutputStream out) throws IOException {
    // in getTextReader();
    return new OutputStreamWriter(out, body.newEncoder());
}