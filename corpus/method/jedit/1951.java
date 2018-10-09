/**
		Generate a ParseException with the specified message, pointing to the
		current token.
		The auto-generated Parser.generateParseException() method does not
		provide line number info, therefore we do this.
	*/
ParseException createParseException(String message) {
    Token errortok = token;
    int line = errortok.beginLine, column = errortok.beginColumn;
    String mess = (errortok.kind == 0) ? tokenImage[0] : errortok.image;
    return new ParseException("Parse error at line " + line + ", column " + column + " : " + message);
}