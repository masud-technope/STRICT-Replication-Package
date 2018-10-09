private static StringBuilder lazyAppend(StringBuilder buf, char ch) {
    if (buf == null)
        buf = new StringBuilder();
    if (buf.indexOf(String.valueOf(ch)) == -1)
        buf.append(ch);
    return buf;
}