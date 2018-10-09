public  TagDecl(String tagName, Attributes attrs) {
    this.tagName = tagName;
    String tmp;
    propName = attrs.getValue("NAME");
    propValue = attrs.getValue("VALUE");
    tmp = attrs.getValue("TYPE");
    if (tmp != null) {
        lastTokenID = Token.stringToToken(tmp);
        if (lastTokenID == -1)
            error("token-invalid", tmp);
    }
    lastMatchType = ParserRule.MATCH_TYPE_RULE;
    // check for the deprecated "EXCLUDE_MATCH" and
    // warn if found.
    tmp = attrs.getValue("EXCLUDE_MATCH");
    if (tmp != null) {
        Log.log(Log.WARNING, this, modeName + ": EXCLUDE_MATCH is deprecated");
        if ("TRUE".equalsIgnoreCase(tmp)) {
            lastMatchType = ParserRule.MATCH_TYPE_CONTEXT;
        }
    }
    // override with the newer MATCH_TYPE if present
    tmp = attrs.getValue("MATCH_TYPE");
    if (tmp != null) {
        if ("CONTEXT".equals(tmp)) {
            lastMatchType = ParserRule.MATCH_TYPE_CONTEXT;
        } else if ("RULE".equals(tmp)) {
            lastMatchType = ParserRule.MATCH_TYPE_RULE;
        } else {
            lastMatchType = Token.stringToToken(tmp);
            if (lastMatchType == -1)
                error("token-invalid", tmp);
        }
    }
    lastAtLineStart = "TRUE".equals(attrs.getValue("AT_LINE_START"));
    lastAtWhitespaceEnd = "TRUE".equals(attrs.getValue("AT_WHITESPACE_END"));
    lastAtWordStart = "TRUE".equals(attrs.getValue("AT_WORD_START"));
    lastNoLineBreak = "TRUE".equals(attrs.getValue("NO_LINE_BREAK"));
    lastNoWordBreak = "TRUE".equals(attrs.getValue("NO_WORD_BREAK"));
    lastIgnoreCase = (attrs.getValue("IGNORE_CASE") == null || "TRUE".equals(attrs.getValue("IGNORE_CASE")));
    lastHighlightDigits = "TRUE".equals(attrs.getValue("HIGHLIGHT_DIGITS"));
    lastRegexp = "TRUE".equals(attrs.getValue("REGEXP"));
    lastDigitRE = attrs.getValue("DIGIT_RE");
    tmp = attrs.getValue("NO_WORD_SEP");
    if (tmp != null)
        lastNoWordSep = tmp;
    tmp = attrs.getValue("AT_CHAR");
    if (tmp != null) {
        try {
            termChar = Integer.parseInt(tmp);
        } catch (NumberFormatException e) {
            error("termchar-invalid", tmp);
            termChar = -1;
        }
    }
    lastEscape = attrs.getValue("ESCAPE");
    lastSetName = attrs.getValue("SET");
    tmp = attrs.getValue("DELEGATE");
    if (tmp != null) {
        String delegateMode, delegateSetName;
        int index = tmp.indexOf("::");
        if (index != -1) {
            delegateMode = tmp.substring(0, index);
            delegateSetName = tmp.substring(index + 2);
        } else {
            delegateMode = modeName;
            delegateSetName = tmp;
        }
        TokenMarker delegateMarker = getTokenMarker(delegateMode);
        if (delegateMarker == null)
            error("delegate-invalid", tmp);
        else {
            lastDelegateSet = delegateMarker.getRuleSet(delegateSetName);
            if (delegateMarker == marker && lastDelegateSet == null) {
                // stupid hack to handle referencing
                // a rule set that is defined later!
                lastDelegateSet = new ParserRuleSet(delegateMode, delegateSetName);
                lastDelegateSet.setDefault(Token.INVALID);
                marker.addRuleSet(lastDelegateSet);
            } else if (lastDelegateSet == null)
                error("delegate-invalid", tmp);
        }
    }
    tmp = attrs.getValue("DEFAULT");
    if (tmp != null) {
        lastDefaultID = Token.stringToToken(tmp);
        if (lastDefaultID == -1) {
            error("token-invalid", tmp);
            lastDefaultID = Token.NULL;
        }
    }
    lastHashChar = attrs.getValue("HASH_CHAR");
    lastHashChars = attrs.getValue("HASH_CHARS");
    if ((null != lastHashChar) && (null != lastHashChars)) {
        error("hash-char-and-hash-chars-mutually-exclusive", null);
        lastHashChars = null;
    }
}