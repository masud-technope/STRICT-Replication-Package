//}}}
//{{{ getSymbolicModifierName() method
/**
	 * Returns a the symbolic modifier name for the specified Java modifier
	 * flag.
	 *
	 * @param mod A modifier constant from <code>InputEvent</code>
	 *
	 * @since jEdit 4.1pre3
	 */
public static char getSymbolicModifierName(int mod) {
    return KeyEventTranslator.getSymbolicModifierName(mod);
}