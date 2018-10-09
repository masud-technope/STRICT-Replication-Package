//}}}
//{{{ doFontSubstitution() method
private static void doFontSubstitution(FontSubstitution subst, Font mainFont, char[] text, int start, int end) {
    for (; ; ) {
        assert start < end;
        int nextChar = Character.codePointAt(text, start);
        int charCount = Character.charCount(nextChar);
        assert !mainFont.canDisplay(nextChar);
        Font substFont = getSubstFont(nextChar);
        if (substFont != null) {
            substFont = deriveSubstFont(mainFont, substFont);
            subst.addRange(substFont, charCount);
        } else {
            subst.addNonSubstRange(charCount);
        }
        start += charCount;
        if (start >= end) {
            break;
        }
        int nextSubstStart = mainFont.canDisplayUpTo(text, start, end);
        if (nextSubstStart == -1) {
            subst.addNonSubstRange(end - start);
            break;
        }
        subst.addNonSubstRange(nextSubstStart - start);
        start = nextSubstStart;
    }
}