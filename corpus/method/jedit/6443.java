//{{{ Chunk constructor
 Chunk(byte id, int offset, int length, ParserRuleSet rules, SyntaxStyle style, Color background) {
    super(id, offset, length, rules);
    this.style = style;
    this.background = background;
    assert isAccessible();
    assert !isInitialized();
}