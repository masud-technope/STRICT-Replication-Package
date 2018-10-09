//}}}
//{{{ setAutoMnemonic() method
/**
	 * Sets the mnemonic for the given button using jEdit convention,
	 * taking the letter after the dollar.
	 * @param button The button to set the mnemonic for.
	 * @since jEdit 5.1
	 * @deprecated use {@link GenericGUIUtilities#setAutoMnemonic(AbstractButton)}
	 */
public static void setAutoMnemonic(AbstractButton button) {
    GenericGUIUtilities.setAutoMnemonic(button);
}