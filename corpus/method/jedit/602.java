/**
	 * Adds a component to the option pane. Components are
	 * added in a vertical fashion, one per row.
	 * @param comp The component
	 */
public void addComponent(Component comp) {
    GridBagConstraints cons = new GridBagConstraints();
    cons.gridy = y++;
    cons.gridheight = 1;
    cons.gridwidth = GridBagConstraints.REMAINDER;
    cons.fill = GridBagConstraints.NONE;
    cons.anchor = GridBagConstraints.WEST;
    cons.weightx = 1.0f;
    cons.insets = new Insets(6, 0, 0, 0);
    gridBag.setConstraints(comp, cons);
    add(comp);
}