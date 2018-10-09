//{{{ Chunk constructor
 Chunk(byte id, int offset, int length, ParserRuleSet rules, SyntaxStyle[] styles, byte defaultID) {
    super(id, offset, length, rules);
    style = styles[id];
    background = style.getBackgroundColor();
    if (background == null)
        background = styles[defaultID].getBackgroundColor();
    assert isAccessible();
    assert !isInitialized();
}