//{{{ readURI() method
private static URL readURI(DataInputStream din) throws IOException {
    String str = readString(din);
    if (str == null)
        return null;
    else
        return new URL(str);
//}}}
}