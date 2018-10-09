//}}}
//{{{ markKeyword() method
private void markKeyword(boolean addRemaining) {
    int len = pos - lastOffset;
    if (len == 0)
        return;
    //{{{ Do digits
    if (context.rules.getHighlightDigits()) {
        boolean digit = false;
        boolean mixed = false;
        for (int i = lastOffset; i < pos; i++) {
            char ch = line.array[i];
            if (Character.isDigit(ch))
                digit = true;
            else
                mixed = true;
        }
        if (mixed) {
            Pattern digitRE = context.rules.getDigitRegexp();
            // digits; if all digits, no point matching
            if (digit) {
                if (digitRE == null) {
                    // mixed digit/alpha keyword,
                    // and no regexp... don't
                    // highlight as DIGIT
                    digit = false;
                } else {
                    int oldCount = line.count;
                    int oldOffset = line.offset;
                    line.offset = lastOffset;
                    line.count = len;
                    CharSequence seq = new SegmentCharSequence(line);
                    digit = digitRE.matcher(seq).matches();
                    line.offset = oldOffset;
                    line.count = oldCount;
                }
            }
        }
        if (digit) {
            tokenHandler.handleToken(line, Token.DIGIT, lastOffset - line.offset, len, context);
            lastOffset = pos;
            return;
        }
    //}}}
    }
    //{{{ Do keywords
    if (keywords != null) {
        byte id = keywords.lookup(line, lastOffset, len);
        if (id != Token.NULL) {
            tokenHandler.handleToken(line, id, lastOffset - line.offset, len, context);
            lastOffset = pos;
            return;
        }
    //}}}
    }
    //{{{ Handle any remaining crud
    if (addRemaining) {
        tokenHandler.handleToken(line, context.rules.getDefault(), lastOffset - line.offset, len, context);
        lastOffset = pos;
    //}}}
    }
}