//}}}
//{{{ Private members
//{{{ getNonAlphaNumericWordChars() method
private static String getNonAlphaNumericWordChars(Buffer buffer, KeywordMap keywordMap) {
    // figure out what constitutes a word character and what
    // doesn't
    String noWordSep = buffer.getStringProperty("noWordSep");
    if (noWordSep == null)
        noWordSep = "";
    if (keywordMap != null) {
        String keywordNoWordSep = keywordMap.getNonAlphaNumericChars();
        if (keywordNoWordSep != null)
            noWordSep += keywordNoWordSep;
    }
    return noWordSep;
}