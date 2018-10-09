/**
	 * Constructs a virtual indent appears at the beggining of a wrapped line.
	 */
 Chunk(float width, int offset, ParserRuleSet rules) {
    super(Token.NULL, offset, 0, rules);
    this.width = width;
    assert !isAccessible();
    assert isInitialized();
}