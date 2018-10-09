//}}}
//{{{ getSubstFont() method
/**
	 * Returns the first font which can display a character from
	 * configured substitution candidates, or null if there is no
	 * such font.
	 */
public static Font getSubstFont(int codepoint) {
    // > symbols from a non-unicode font in my system.
    if (Character.isISOControl(codepoint))
        return null;
    for (Font candidate : getFontSubstList()) {
        if (candidate.canDisplay(codepoint)) {
            return candidate;
        }
    }
    return null;
}