//}}}
//{{{ setAutoMnemonic() method
/**
	 * Sets the mnemonic for the given button using jEdit convention,
	 * taking the letter after the dollar.
	 * @param button The button to set the mnemonic for.
	 * @since jEdit 5.3.1
	 */
public static void setAutoMnemonic(AbstractButton button) {
    String label = button.getText();
    char mnemonic;
    int index = label.indexOf('$');
    if (index != -1 && label.length() - index > 1) {
        mnemonic = Character.toLowerCase(label.charAt(index + 1));
        label = label.substring(0, index).concat(label.substring(++index));
    } else {
        mnemonic = '\0';
    }
    if (mnemonic != '\0') {
        button.setMnemonic(mnemonic);
        button.setText(label);
    }
}