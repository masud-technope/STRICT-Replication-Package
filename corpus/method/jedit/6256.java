//}}}
//{{{ setWholeWord() method
/**
	 * Sets the whole word flag.
	 * @param wholeWord True if only whole words should be searched,
	 * false otherwise
	 * @since 4.5pre1
	 */
public static void setWholeWord(boolean wholeWord) {
    if (wholeWord == SearchAndReplace.wholeWord)
        return;
    SearchAndReplace.wholeWord = wholeWord;
    matcher = null;
    EditBus.send(new SearchSettingsChanged(null));
}