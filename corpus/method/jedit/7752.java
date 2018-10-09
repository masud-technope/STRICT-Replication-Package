private  Native2ASCIIReader(@Nonnull InputStream in, boolean permissive, @Nullable Class<? extends PushbackReader> clazz) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
    super(clazz == null ? new PushbackReader(iso_8859_1Encoding.getTextReader(in), 5) : clazz.getConstructor(Reader.class, int.class).newInstance(iso_8859_1Encoding.getTextReader(in), 5));
    this.in = (PushbackReader) super.in;
    this.permissive = permissive;
}