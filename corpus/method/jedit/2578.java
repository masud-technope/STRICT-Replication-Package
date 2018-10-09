//}}}
//}}}
//{{{ Syntax highlighting
//{{{ getLineContext() method
/**
	 * Returns the line context of the token marker for the specified line.
	 */
public TokenMarker.LineContext getLineContext(int line) {
    return lineMgr.getLineContext(line);
}