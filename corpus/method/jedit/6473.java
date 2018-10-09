//}}}
//{{{ add() method
/**
	 * Adds a key-value mapping.
	 * @param keyword The key
	 * @param id The value
	 * @since jEdit 4.2pre3
	 */
public void add(char[] keyword, byte id) {
    int key = getStringMapKey(keyword);
    // characters used in a keyword map.
    loop: for (char ch : keyword) {
        if (!Character.isLetterOrDigit(ch)) {
            for (int j = 0; j < noWordSep.length(); j++) {
                if (noWordSep.charAt(j) == ch)
                    continue loop;
            }
            noWordSep.append(ch);
        }
    }
    map[key] = new Keyword(keyword, id, map[key]);
}