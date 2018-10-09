/**
	 * Adds a labeled component to the option pane. Components are
	 * added in a vertical fashion, one per row. The label is
	 * displayed to the left of the component.
	 * @param label The label
	 * @param comp The component
	 * @param fill Fill parameter to GridBagConstraints for the right
	 * component
	 */
public void addComponent(String label, Component comp, int fill) {
    JLabel l = newLabel(label, comp);
    l.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 12));
    addComponent(l, comp, fill);
}