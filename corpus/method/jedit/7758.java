//}}}
//{{{ Package private members
@Nonnull
Reader getTextReader(@Nonnull InputStream in, @Nullable Class<? extends PushbackReader> clazz) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    return new Native2ASCIIReader(in, false, clazz);
}