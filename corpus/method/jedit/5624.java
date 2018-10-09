//{{{ readLanguagesMap() method
private static Map<String, Properties> readLanguagesMap(DataInputStream din) throws IOException {
    int languagesCount = din.readInt();
    if (languagesCount == 0)
        return Collections.emptyMap();
    Map<String, Properties> languages = new HashMap<String, Properties>(languagesCount);
    for (int i = 0; i < languagesCount; i++) {
        String lang = readString(din);
        Properties props = readMap(din);
        languages.put(lang, props);
    }
    return languages;
//}}}
}