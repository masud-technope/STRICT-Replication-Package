//{{{ writeMap() method
private static void writeMap(DataOutputStream dout, Properties properties) throws IOException {
    dout.writeInt(properties.size());
    Set<Map.Entry<Object, Object>> set = properties.entrySet();
    for (Map.Entry<Object, Object> entry : set) {
        writeString(dout, entry.getKey());
        writeString(dout, entry.getValue());
    }
//}}}
}