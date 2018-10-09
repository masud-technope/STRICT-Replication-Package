// }}}
//{{{ addComponent() method
/**
	 * Adds a labeled component to the option pane. Components are
	 * added in a vertical fashion, one per row. The label is
	 * displayed to the left of the component.
	 * @param label The label
	 * @param comp The component
	 */
public void addComponent(String label, Component comp) {
    JLabel l = newLabel(label, comp);
    l.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 12));
    addComponent(l, comp, GridBagConstraints.BOTH);
}