public TarEntry createEntry(File path) throws InvalidHeaderException {
    return new TarEntry(path);
}