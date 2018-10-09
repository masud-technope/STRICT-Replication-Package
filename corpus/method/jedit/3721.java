//}}}
//{{{ getSymbolicModifierName() method
/**
	 * Returns a the symbolic modifier name for the specified Java modifier
	 * flag.
	 *
	 * @param mod A modifier constant from <code>InputEvent</code>
	 *
	 * @since jEdit 4.2pre3
	 */
public static char getSymbolicModifierName(int mod) {
    if ((mod & c) != 0)
        return 'C';
    else if ((mod & a) != 0)
        return 'A';
    else if ((mod & m) != 0)
        return 'M';
    else if ((mod & s) != 0)
        return 'S';
    else
        return '\0';
}