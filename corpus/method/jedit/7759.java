@Nonnull
Reader getPermissiveTextReader(@Nonnull InputStream in, @Nullable Class<? extends PushbackReader> clazz) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    return new Native2ASCIIReader(in, true, clazz);
}