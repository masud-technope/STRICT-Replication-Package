//}}}
//{{{ toString() method
public String toString() {
    StringBuilder result = new StringBuilder();
    result.append(getClass().getName()).append("[action=");
    switch(action & MAJOR_ACTIONS) {
        case SEQ:
            result.append("SEQ");
            break;
        case SPAN:
            result.append("SPAN");
            break;
        case MARK_PREVIOUS:
            result.append("MARK_PREVIOUS");
            break;
        case MARK_FOLLOWING:
            result.append("MARK_FOLLOWING");
            break;
        case EOL_SPAN:
            result.append("EOL_SPAN");
            break;
        default:
            result.append("UNKNOWN");
            break;
    }
    int actionHints = action & ACTION_HINTS;
    result.append("[matchType=").append(matchType == MATCH_TYPE_CONTEXT ? "MATCH_TYPE_CONTEXT" : (matchType == MATCH_TYPE_RULE ? "MATCH_TYPE_RULE" : Token.tokenToString(matchType)));
    result.append(",NO_LINE_BREAK=").append((actionHints & NO_LINE_BREAK) != 0);
    result.append(",NO_WORD_BREAK=").append((actionHints & NO_WORD_BREAK) != 0);
    result.append(",IS_ESCAPE=").append((actionHints & IS_ESCAPE) != 0);
    result.append(",REGEXP=").append((actionHints & REGEXP) != 0);
    result.append("],upHashChar=").append(new String(upHashChar));
    result.append(",upHashChars=").append(Arrays.toString(upHashChars));
    result.append(",startPosMatch=");
    result.append("[AT_LINE_START=").append((startPosMatch & AT_LINE_START) != 0);
    result.append(",AT_WHITESPACE_END=").append((startPosMatch & AT_WHITESPACE_END) != 0);
    result.append(",AT_WORD_START=").append((startPosMatch & AT_WORD_START) != 0);
    result.append("],start=").append(null == start ? null : String.valueOf(start));
    result.append(",startRegexp=").append(startRegexp);
    result.append(",endPosMatch=");
    result.append("[AT_LINE_START=").append((endPosMatch & AT_LINE_START) != 0);
    result.append(",AT_WHITESPACE_END=").append((endPosMatch & AT_WHITESPACE_END) != 0);
    result.append(",AT_WORD_START=").append((endPosMatch & AT_WORD_START) != 0);
    result.append("],end=").append(null == end ? null : String.valueOf(end));
    result.append(",delegate=").append(delegate);
    result.append(",escapeRule=").append(escapeRule);
    result.append(",token=").append(Token.tokenToString(token)).append(']');
    return result.toString();
}