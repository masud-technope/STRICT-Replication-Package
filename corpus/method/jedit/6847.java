//}}}
//{{{ userInput() method
/**
	 * Handles the insertion of the specified character. It performs the
	 * following operations in addition to TextArea#userInput(char):
	 * <ul>
	 * <li>Inserting a space with automatic abbrev expansion enabled will
	 * try to expand the abbrev
	 * </ul>
	 *
	 * @param ch The character
	 * @since jEdit 2.7pre3
	 */
@Override
public void userInput(char ch) {
    if (ch == ' ' && Abbrevs.getExpandOnInput() && Abbrevs.expandAbbrev(view, false))
        return;
    super.userInput(ch);
}