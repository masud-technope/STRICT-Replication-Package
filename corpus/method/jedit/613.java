/**
	 * Adds a labeled component to the option pane. Components are
	 * added in a vertical fashion, one per row. The label is
	 * displayed to the left of the component.
	 * @param comp1 The label
	 * @param comp2 The component
	 *
	 * @since jEdit 4.1pre3
	 */
public void addComponent(Component comp1, Component comp2) {
    addComponent(comp1, comp2, GridBagConstraints.BOTH);
}