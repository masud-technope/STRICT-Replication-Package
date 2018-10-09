//}}}
//{{{ addCurrentToHistory() method
/**
	 * Adds the currently entered item to the history.
	 */
public void addCurrentToHistory() {
    if (historyModel != null)
        historyModel.addItem(getText());
    index = 0;
}