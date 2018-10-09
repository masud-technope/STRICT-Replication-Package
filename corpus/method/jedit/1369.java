/**
		Print the error with line number and stack trace.
	*/
public String toString() {
    String trace;
    if (node != null)
        trace = " : at Line: " + node.getLineNumber() + " :\n in file: " + node.getSourceFile() + "\n : " + node.getText();
    else
        // Users should not normally see this.
        trace = ": <at unknown location>";
    if (callstack != null)
        trace = trace + "\n" + getScriptStackTrace();
    return getMessage() + trace;
}