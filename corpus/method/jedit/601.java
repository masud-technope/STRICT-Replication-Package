/**
	 * Adds a labeled component to the option pane. Components are
	 * added in a vertical fashion, one per row. The label is
	 * displayed to the left of the component.
	 * @param comp1 The label
	 * @param comp2 The component
	 * @param fill Fill parameter to GridBagConstraints for the right
	 * component
	 *
	 * @since jEdit 4.1pre3
	 */
public void addComponent(Component comp1, Component comp2, int fill) {
    copyToolTips(comp1, comp2);
    GridBagConstraints cons = new GridBagConstraints();
    cons.gridy = y++;
    cons.gridheight = 1;
    cons.gridwidth = 1;
    cons.weightx = 0.0f;
    cons.insets = new Insets(6, 0, 0, 6);
    cons.fill = GridBagConstraints.BOTH;
    gridBag.setConstraints(comp1, cons);
    add(comp1);
    cons.fill = fill;
    cons.gridx = 1;
    cons.weightx = 1.0f;
    gridBag.setConstraints(comp2, cons);
    add(comp2);
}