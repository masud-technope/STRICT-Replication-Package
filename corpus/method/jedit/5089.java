private boolean canBePathPrefix(String s) {
    return !s.contains(File.pathSeparator) && new File(s).isAbsolute();
}