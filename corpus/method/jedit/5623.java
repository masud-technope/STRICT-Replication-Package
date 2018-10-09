//{{{ writeString() method
private static void writeString(DataOutputStream dout, Object obj) throws IOException {
    if (obj == null) {
        dout.writeInt(0);
    } else {
        String str = obj.toString();
        dout.writeInt(str.length());
        dout.writeChars(str);
    }
//}}}
}