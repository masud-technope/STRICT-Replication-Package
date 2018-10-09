//{{{ writeBooleanArray() method
private static void writeBooleanArray(DataOutputStream dout, boolean[] bools) throws IOException {
    if (bools == null) {
        dout.writeInt(0);
    } else {
        dout.writeInt(bools.length);
        for (boolean bool : bools) dout.writeBoolean(bool);
    }
//}}}
}