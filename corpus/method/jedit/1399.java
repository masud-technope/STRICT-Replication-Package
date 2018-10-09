/**
		Specify the source of the text from which this interpreter is reading.
		Note: there is a difference between what file the interrpeter is
		sourcing and from what file a method was originally parsed.  One
		file may call a method sourced from another file.  See SimpleNode
		for origination file info.
		@see org.gjt.sp.jedit.bsh.SimpleNode#getSourceFile()
	*/
public String getSourceFileInfo() {
    if (sourceFileInfo != null)
        return sourceFileInfo;
    else
        return "<unknown source>";
}