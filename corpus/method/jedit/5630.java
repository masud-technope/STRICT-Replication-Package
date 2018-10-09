//{{{ writeLanguages() method
private static void writeLanguages(DataOutputStream dout, Map<String, Properties> languages) throws IOException {
    dout.writeInt(languages.size());
    for (Map.Entry<String, Properties> entry : languages.entrySet()) {
        writeString(dout, entry.getKey());
        writeMap(dout, entry.getValue());
    }
//}}}
}