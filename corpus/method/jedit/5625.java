//{{{ readMap() method
private static Properties readMap(DataInputStream din) throws IOException {
    Properties returnValue = new Properties();
    int count = din.readInt();
    for (int i = 0; i < count; i++) {
        String key = readString(din);
        String value = readString(din);
        if (value == null)
            value = "";
        returnValue.setProperty(key, value);
    }
    return returnValue;
//}}}
}