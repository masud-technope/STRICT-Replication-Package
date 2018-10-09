/*
		You can override these two methods in subclasses of SimpleNode to
		customize the way the node appears when the tree is dumped.  If
		your output uses more than one line you should override
		toString(String), otherwise overriding toString() is probably all
		you need to do.
	*/
public String toString() {
    return ParserTreeConstants.jjtNodeName[id];
}