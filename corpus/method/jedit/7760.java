private  Native2ASCIIReader(@Nonnull InputStream in, boolean permissive) throws IOException {
    super(new PushbackReader(iso_8859_1Encoding.getTextReader(in), 5));
    this.in = (PushbackReader) super.in;
    this.permissive = permissive;
}