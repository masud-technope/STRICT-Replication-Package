//}}}
//{{{ tokenToString() method
/**
	 * Converts a token type constant to a token type string.
	 * @since jEdit 4.2pre1
	 */
public static String tokenToString(byte token) {
    return (token == Token.END) ? "END" : TOKEN_TYPES[token % ID_COUNT];
}