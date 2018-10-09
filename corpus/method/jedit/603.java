//}}}
//{{{ addSeparator() methods
/**
	 * Adds a separator component.
	 * @since jEdit 4.1pre7
	 */
public void addSeparator() {
    addComponent(Box.createVerticalStrut(6));
    JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
    GridBagConstraints cons = new GridBagConstraints();
    cons.gridy = y++;
    cons.gridheight = 1;
    cons.gridwidth = GridBagConstraints.REMAINDER;
    cons.fill = GridBagConstraints.BOTH;
    cons.anchor = GridBagConstraints.WEST;
    cons.weightx = 1.0f;
    gridBag.setConstraints(sep, cons);
    add(sep);
    addComponent(Box.createVerticalStrut(6));
}