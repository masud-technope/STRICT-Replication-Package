/**
		Get the name of the source file (or more generally source) of
		the text from which this node was parsed.
		This will recursively search up the chain of parent nodes until
		a source is found or return a string indicating that the source
		is unknown.
	*/
public String getSourceFile() {
    if (sourceFile == null)
        if (parent != null)
            return ((SimpleNode) parent).getSourceFile();
        else
            return "<unknown file>";
    else
        return sourceFile;
}