//}}}
//{{{ setModel() method
/**
	 * Sets the history list controller.
	 * @param name The model name
	 * @since jEdit 4.3pre1
	 */
public void setModel(String name) {
    if (name == null)
        historyModel = null;
    else
        historyModel = HistoryModel.getModel(name);
    index = -1;
}