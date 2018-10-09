/**
   * This constructor is used by the method "generateParseException"
   * in the generated parser.  Calling this constructor generates
   * a new object of this type with the fields "currentToken",
   * "expectedTokenSequences", and "tokenImage" set.  The boolean
   * flag "specialConstructor" is also set to true to indicate that
   * this constructor was used to create this object.
   * This constructor calls its super class with the empty string
   * to force the "toString" method of parent class "Throwable" to
   * print the error message in the form:
   *     ParseException: &lt;result of getMessage&gt;
   */
public  ParseException(Token currentTokenVal, int[][] expectedTokenSequencesVal, String[] tokenImageVal) {
    // Begin BeanShell Modification - constructor
    this();
    // End BeanShell Modification - constructor
    specialConstructor = true;
    currentToken = currentTokenVal;
    expectedTokenSequences = expectedTokenSequencesVal;
    tokenImage = tokenImageVal;
}