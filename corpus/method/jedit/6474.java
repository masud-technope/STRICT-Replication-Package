//}}}
//{{{ add() method
/**
	 * Adds a key-value mapping.
	 * @param keyword The key
	 * @param id The value
	 */
public void add(String keyword, byte id) {
    add(keyword.toCharArray(), id);
}