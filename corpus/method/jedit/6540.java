//{{{ stringToToken() method
/**
	 * Converts a token type string to a token type constant.
	 * @param value The token type
	 * @since jEdit 4.1pre1
	 */
public static byte stringToToken(String value) {
    try {
        Field f = Token.class.getField(value);
        return f.getByte(null);
    } catch (Exception e) {
        return -1;
    }
}