//{{{ implements Encoding
@Nonnull
public Reader getTextReader(@Nonnull InputStream in) throws IOException {
    return new Native2ASCIIReader(in, false);
}