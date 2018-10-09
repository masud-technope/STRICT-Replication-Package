/**
	 * Creates a new token.
	 * @param id The id of the token
	 * @param offset The start offset of the token
	 * @param length The length of the token
	 * @param rules The parser rule set that generated this token
	 */
public  Token(byte id, int offset, int length, ParserRuleSet rules) {
    this.id = id;
    this.offset = offset;
    this.length = length;
    this.rules = rules;
}