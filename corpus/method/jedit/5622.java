//{{{ Private members
//{{{ readString() method
private static String readString(DataInputStream din) throws IOException {
    int len = din.readInt();
    if (len == 0)
        return null;
    char[] str = new char[len];
    for (int i = 0; i < len; i++) str[i] = din.readChar();
    return new String(str);
//}}}
}