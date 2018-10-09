/**
		Get the ending line number of the starting token
	public int getEndLineNumber() {
		return lastToken.endLine;
	}
	*/
/**
		Get the text of the tokens comprising this node.
	*/
public String getText() {
    StringBuilder text = new StringBuilder();
    Token t = firstToken;
    while (t != null) {
        text.append(t.image);
        if (!t.image.equals("."))
            text.append(" ");
        if (t == lastToken || t.image.equals("{") || t.image.equals(";"))
            break;
        t = t.next;
    }
    return text.toString();
}