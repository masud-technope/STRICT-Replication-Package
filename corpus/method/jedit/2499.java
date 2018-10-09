/**
	 * Create a new JEditBuffer.
	 * It is used by independent textarea only
	 */
public  JEditBuffer() {
    properties.put("wrap", new PropValue("none", false));
    properties.put("folding", new PropValue("none", false));
    tokenMarker = new TokenMarker();
    tokenMarker.addRuleSet(new ParserRuleSet("text", "MAIN"));
    setTokenMarker(tokenMarker);
    loadText(null, null);
    // corresponding buffer.XXX properties not set
    if (getProperty(ENCODING) == null)
        properties.put(ENCODING, new PropValue(System.getProperty("file.encoding"), false));
    if (getProperty(LINESEP) == null)
        properties.put(LINESEP, new PropValue(System.getProperty("line.separator"), false));
    setFoldHandler(new DummyFoldHandler());
}