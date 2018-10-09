//{{{ writeStringArray() method
private static void writeStringArray(DataOutputStream dout, String[] str) throws IOException {
    if (str == null) {
        dout.writeInt(0);
    } else {
        dout.writeInt(str.length);
        for (String s : str) writeString(dout, s);
    }
//}}}
}