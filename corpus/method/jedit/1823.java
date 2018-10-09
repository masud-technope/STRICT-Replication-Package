// End BeanShell Modification - moved body to overloaded getMessage()
/**
   * This method has the standard behavior when this object has been
   * created using the standard constructors.  Otherwise, it uses
   * "currentToken" and "expectedTokenSequences" to generate a parse
   * error message and returns it.  If this object has been created
   * due to a parse error, and you do not catch it (it gets thrown
   * from the parser), then this method is called during the printing
   * of the final stack trace, and hence the correct error message
   * gets displayed.
   */
// Begin BeanShell Modification - added debug param
public String getMessage(boolean debug) {
    // End BeanShell Modification - added debug param
    if (!specialConstructor) {
        return super.getMessage();
    }
    String expected = "";
    int maxSize = 0;
    for (int i = 0; i < expectedTokenSequences.length; i++) {
        if (maxSize < expectedTokenSequences[i].length) {
            maxSize = expectedTokenSequences[i].length;
        }
        for (int j = 0; j < expectedTokenSequences[i].length; j++) {
            expected += tokenImage[expectedTokenSequences[i][j]] + " ";
        }
        if (expectedTokenSequences[i][expectedTokenSequences[i].length - 1] != 0) {
            expected += "...";
        }
        expected += eol + "    ";
    }
    // Begin BeanShell Modification - added sourceFile info
    String retval = "In file: " + sourceFile + " Encountered \"";
    // End BeanShell Modification - added sourceFile info
    Token tok = currentToken.next;
    for (int i = 0; i < maxSize; i++) {
        if (i != 0)
            retval += " ";
        if (tok.kind == 0) {
            retval += tokenImage[0];
            break;
        }
        retval += add_escapes(tok.image);
        tok = tok.next;
    }
    retval += "\" at line " + currentToken.next.beginLine + ", column " + currentToken.next.beginColumn + "." + eol;
    // Begin BeanShell Modification - made conditional on debug
    if (debug) {
        if (expectedTokenSequences.length == 1) {
            retval += "Was expecting:" + eol + "    ";
        } else {
            retval += "Was expecting one of:" + eol + "    ";
        }
        retval += expected;
    }
    return retval;
}