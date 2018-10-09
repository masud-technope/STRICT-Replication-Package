//}}}
//{{{ setModifierMapping() method
/**
	 * Changes the mapping between symbolic modifier key names
	 * (<code>C</code>, <code>A</code>, <code>M</code>, <code>S</code>) and
	 * Java modifier flags.
	 *
	 * You can map more than one Java modifier to a symobolic modifier, for
	 * example :
	 * <p><code>
	 	setModifierMapping(
	 		InputEvent.CTRL_DOWN_MASK,
	 		InputEvent.ALT_DOWN_MASK | InputEvent.META_DOWN_MASK,
	 		0,
	 		InputEvent.SHIFT_MASK);
	   </code></p>
	 *
	 * You cannot map a Java modifer to more than one symbolic modifier.
	 *
	 * @param c The modifier(s) to map the <code>C</code> modifier to
	 * @param a The modifier(s) to map the <code>A</code> modifier to
	 * @param m The modifier(s) to map the <code>M</code> modifier to
	 * @param s The modifier(s) to map the <code>S</code> modifier to
	 *
	 * @since jEdit 4.2pre3
	 */
public static void setModifierMapping(int c, int a, int m, int s) {
    int duplicateMapping = (c & a) | (c & m) | (c & s) | (a & m) | (a & s) | (m & s);
    if ((duplicateMapping & InputEvent.CTRL_DOWN_MASK) != 0) {
        throw new IllegalArgumentException("CTRL is mapped to more than one modifier");
    }
    if ((duplicateMapping & InputEvent.ALT_DOWN_MASK) != 0) {
        throw new IllegalArgumentException("ALT is mapped to more than one modifier");
    }
    if ((duplicateMapping & InputEvent.META_DOWN_MASK) != 0) {
        throw new IllegalArgumentException("META is mapped to more than one modifier");
    }
    if ((duplicateMapping & InputEvent.SHIFT_DOWN_MASK) != 0) {
        throw new IllegalArgumentException("SHIFT is mapped to more than one modifier");
    }
    KeyEventTranslator.c = c;
    KeyEventTranslator.a = a;
    KeyEventTranslator.m = m;
    KeyEventTranslator.s = s;
}