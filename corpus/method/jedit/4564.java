@Nonnull
public Writer getTextWriter(@Nonnull OutputStream out) throws IOException {
    out.write(bom);
    return plain.getTextWriter(out);
}