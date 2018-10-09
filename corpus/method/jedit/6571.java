//}}}
//{{{ endElement() method
public void endElement(String uri, String localName, String name) {
    TagDecl tag = popElement();
    if (name.equals(tag.tagName)) {
        if (tag.lastDelegateSet != null && !tag.tagName.equals("IMPORT") && !tag.lastDelegateSet.getModeName().equals(modeName)) {
            Mode mode = ModeProvider.instance.getMode(tag.lastDelegateSet.getModeName());
            if (!reloadModes.contains(mode)) {
                reloadModes.add(mode);
            }
        }
        //{{{ PROPERTY
        if (tag.tagName.equals("PROPERTY")) {
            props.put(propName, propValue);
        //}}}
        } else //{{{ PROPS
        if (tag.tagName.equals("PROPS")) {
            if (peekElement().tagName.equals("RULES"))
                rules.setProperties(props);
            else
                modeProps = props;
            props = new Hashtable<String, String>();
        //}}}
        } else //{{{ RULES
        if (tag.tagName.equals("RULES")) {
            rules.setKeywords(keywords);
            keywords = null;
            rules = null;
        //}}}
        } else //{{{ IMPORT
        if (tag.tagName.equals("IMPORT")) {
            // prevent lockups
            if (!rules.equals(tag.lastDelegateSet)) {
                rules.addRuleSet(tag.lastDelegateSet);
            }
        //}}}
        } else //{{{ TERMINATE
        if (tag.tagName.equals("TERMINATE")) {
            rules.setTerminateChar(tag.termChar);
        //}}}
        } else //{{{ SEQ
        if (tag.tagName.equals("SEQ")) {
            if (tag.lastStart == null) {
                error("empty-tag", "SEQ");
                return;
            }
            rules.addRule(ParserRule.createSequenceRule(tag.lastStartPosMatch, tag.lastStart.toString(), tag.lastDelegateSet, tag.lastTokenID));
        //}}}
        } else //{{{ SEQ_REGEXP
        if (tag.tagName.equals("SEQ_REGEXP")) {
            if (tag.lastStart == null) {
                error("empty-tag", "SEQ_REGEXP");
                return;
            }
            try {
                if (null != tag.lastHashChars) {
                    rules.addRule(ParserRule.createRegexpSequenceRule(tag.lastStartPosMatch, tag.lastHashChars.toCharArray(), tag.lastStart.toString(), tag.lastDelegateSet, tag.lastTokenID, findParent("RULES").lastIgnoreCase));
                } else {
                    rules.addRule(ParserRule.createRegexpSequenceRule(tag.lastHashChar, tag.lastStartPosMatch, tag.lastStart.toString(), tag.lastDelegateSet, tag.lastTokenID, findParent("RULES").lastIgnoreCase));
                }
            } catch (PatternSyntaxException re) {
                error("regexp", re);
            }
        //}}}
        } else //{{{ SPAN
        if (tag.tagName.equals("SPAN")) {
            if (tag.lastStart == null) {
                error("empty-tag", "BEGIN");
                return;
            }
            if (tag.lastEnd == null) {
                error("empty-tag", "END");
                return;
            }
            rules.addRule(ParserRule.createSpanRule(tag.lastStartPosMatch, tag.lastStart.toString(), tag.lastEndPosMatch, tag.lastEnd.toString(), tag.lastDelegateSet, tag.lastTokenID, tag.lastMatchType, tag.lastNoLineBreak, tag.lastNoWordBreak, tag.lastEscape));
        //}}}
        } else //{{{ SPAN_REGEXP
        if (tag.tagName.equals("SPAN_REGEXP")) {
            if (tag.lastStart == null) {
                error("empty-tag", "BEGIN");
                return;
            }
            if (tag.lastEnd == null) {
                error("empty-tag", "END");
                return;
            }
            try {
                if (null != tag.lastHashChars) {
                    rules.addRule(ParserRule.createRegexpSpanRule(tag.lastStartPosMatch, tag.lastHashChars.toCharArray(), tag.lastStart.toString(), tag.lastEndPosMatch, tag.lastEnd.toString(), tag.lastDelegateSet, tag.lastTokenID, tag.lastMatchType, tag.lastNoLineBreak, tag.lastNoWordBreak, findParent("RULES").lastIgnoreCase, tag.lastEscape, tag.lastEndRegexp));
                } else {
                    rules.addRule(ParserRule.createRegexpSpanRule(tag.lastHashChar, tag.lastStartPosMatch, tag.lastStart.toString(), tag.lastEndPosMatch, tag.lastEnd.toString(), tag.lastDelegateSet, tag.lastTokenID, tag.lastMatchType, tag.lastNoLineBreak, tag.lastNoWordBreak, findParent("RULES").lastIgnoreCase, tag.lastEscape, tag.lastEndRegexp));
                }
            } catch (PatternSyntaxException re) {
                error("regexp", re);
            }
        //}}}
        } else //{{{ EOL_SPAN
        if (tag.tagName.equals("EOL_SPAN")) {
            if (tag.lastStart == null) {
                error("empty-tag", "EOL_SPAN");
                return;
            }
            rules.addRule(ParserRule.createEOLSpanRule(tag.lastStartPosMatch, tag.lastStart.toString(), tag.lastDelegateSet, tag.lastTokenID, tag.lastMatchType));
        //}}}
        } else //{{{ EOL_SPAN_REGEXP
        if (tag.tagName.equals("EOL_SPAN_REGEXP")) {
            if (tag.lastStart == null) {
                error("empty-tag", "EOL_SPAN_REGEXP");
                return;
            }
            try {
                if (null != tag.lastHashChars) {
                    rules.addRule(ParserRule.createRegexpEOLSpanRule(tag.lastStartPosMatch, tag.lastHashChars.toCharArray(), tag.lastStart.toString(), tag.lastDelegateSet, tag.lastTokenID, tag.lastMatchType, findParent("RULES").lastIgnoreCase));
                } else {
                    rules.addRule(ParserRule.createRegexpEOLSpanRule(tag.lastHashChar, tag.lastStartPosMatch, tag.lastStart.toString(), tag.lastDelegateSet, tag.lastTokenID, tag.lastMatchType, findParent("RULES").lastIgnoreCase));
                }
            } catch (PatternSyntaxException re) {
                error("regexp", re);
            }
        //}}}
        } else //{{{ MARK_FOLLOWING
        if (tag.tagName.equals("MARK_FOLLOWING")) {
            if (tag.lastStart == null) {
                error("empty-tag", "MARK_FOLLOWING");
                return;
            }
            rules.addRule(ParserRule.createMarkFollowingRule(tag.lastStartPosMatch, tag.lastStart.toString(), tag.lastTokenID, tag.lastMatchType));
        //}}}
        } else //{{{ MARK_PREVIOUS
        if (tag.tagName.equals("MARK_PREVIOUS")) {
            if (tag.lastStart == null) {
                error("empty-tag", "MARK_PREVIOUS");
                return;
            }
            rules.addRule(ParserRule.createMarkPreviousRule(tag.lastStartPosMatch, tag.lastStart.toString(), tag.lastTokenID, tag.lastMatchType));
        //}}}
        } else //{{{ Keywords
        if (!tag.tagName.equals("END") && !tag.tagName.equals("BEGIN") && !tag.tagName.equals("KEYWORDS") && !tag.tagName.equals("MODE")) {
            byte token = Token.stringToToken(tag.tagName);
            if (token != -1) {
                if (tag.lastKeyword == null || tag.lastKeyword.length() == 0) {
                    error("empty-keyword", null);
                } else {
                    addKeyword(tag.lastKeyword.toString(), token);
                }
            }
        //}}}
        }
    } else {
        // can't happen
        throw new InternalError();
    }
}