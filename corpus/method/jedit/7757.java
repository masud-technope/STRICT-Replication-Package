@Nonnull
public Reader getPermissiveTextReader(@Nonnull InputStream in) throws IOException {
    return new Native2ASCIIReader(in, true);
}