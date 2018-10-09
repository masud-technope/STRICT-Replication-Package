/**
	 * Creates a new history text field.
	 * @param name The history model name
	 * @param instantPopups If true, selecting a value from the history
	 * popup will immediately fire an ActionEvent. If false, the user
	 * will have to press 'Enter' first
	 *
	 * @since jEdit 2.2pre5
	 */
public  HistoryTextField(String name, boolean instantPopups) {
    this(name, instantPopups, true);
}