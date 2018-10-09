//}}}
//{{{ nextMatch() method
@Override
public SearchMatcher.Match nextMatch(CharSequence text, boolean start, boolean end, boolean firstTime, boolean reverse) throws InterruptedException {
    int pos = match(text, reverse);
    if (pos == -1) {
        return null;
    } else {
        returnValue.start = pos;
        returnValue.end = pos + pattern.length;
        int _end = returnValue.end;
        if (wholeWord) {
            CharSequence subText;
            while (!isWholeWord(text, returnValue.start, returnValue.end)) {
                subText = text.subSequence(returnValue.end, text.length());
                Match match = nextMatch(subText, start, end, firstTime, reverse);
                // match == returnValue or null
                if (match == null)
                    return null;
                match.start += _end;
                _end += match.end;
                match.end = match.start + pattern.length;
            }
        }
        return returnValue;
    }
}