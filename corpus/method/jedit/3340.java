private List<Key> parseShortcut(String shortcut) {
    String[] parts = shortcut.split("\\s+");
    List<Key> keys = new ArrayList<Key>(parts.length);
    for (String part : parts) {
        if (part.length() > 0)
            keys.add(KeyEventTranslator.parseKey(part));
    }
    return keys;
}