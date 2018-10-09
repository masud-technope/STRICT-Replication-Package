//{{{ readBooleanArray() method
private static boolean[] readBooleanArray(DataInputStream din) throws IOException {
    int len = din.readInt();
    if (len == 0)
        return null;
    boolean[] bools = new boolean[len];
    for (int i = 0; i < len; i++) {
        bools[i] = din.readBoolean();
    }
    return bools;
//}}}
}