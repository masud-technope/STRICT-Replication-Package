//{{{ addTranslation() method
/**
	 * Adds a keyboard translation.
	 * @param key1 Translate this key
	 * @param key2 Into this key
	 * @since jEdit 4.2pre3
	 */
public static void addTranslation(Key key1, Key key2) {
    transMap.put(key1, key2);
}