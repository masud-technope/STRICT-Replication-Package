//{{{ readStringArray() method
private static String[] readStringArray(DataInputStream din) throws IOException {
    int len = din.readInt();
    if (len == 0)
        return null;
    String[] str = new String[len];
    for (int i = 0; i < len; i++) {
        str[i] = readString(din);
    }
    return str;
//}}}
}