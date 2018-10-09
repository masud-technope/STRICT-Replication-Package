/**
	 * Creates a new history text field.
	 * @param name The history model name
	 * @param instantPopups If true, selecting a value from the history
	 * popup will immediately fire an ActionEvent. If false, the user
	 * will have to press 'Enter' first
	 * @param enterAddsToHistory If true, pressing the Enter key will
	 * automatically add the currently entered text to the history.
	 *
	 * @since jEdit 2.6pre5
	 */
public  HistoryTextField(String name, boolean instantPopups, boolean enterAddsToHistory) {
    // set sane minumum number of columns
    super(4);
    controller = new HistoryText(this, null) {

        public void fireActionPerformed() {
            HistoryTextField.this.fireActionPerformed();
        }
    };
    setModel(name);
    MouseHandler mouseHandler = new MouseHandler();
    addMouseListener(mouseHandler);
    addMouseMotionListener(mouseHandler);
    setInstantPopups(instantPopups);
    setEnterAddsToHistory(enterAddsToHistory);
}