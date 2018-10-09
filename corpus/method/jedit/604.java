/**
	 * Adds a separator component.
	 * @param label The separator label property
	 * @since jEdit 2.6pre2
	 */
public void addSeparator(String label) {
    if (y != 0)
        addComponent(Box.createVerticalStrut(6));
    Box box = new Box(BoxLayout.X_AXIS);
    Box box2 = new Box(BoxLayout.Y_AXIS);
    box2.add(Box.createGlue());
    box2.add(new JSeparator(SwingConstants.HORIZONTAL));
    box2.add(Box.createGlue());
    box.add(box2);
    JLabel l = new JLabel(jEdit.getProperty(label));
    l.setMaximumSize(l.getPreferredSize());
    box.add(l);
    Box box3 = new Box(BoxLayout.Y_AXIS);
    box3.add(Box.createGlue());
    box3.add(new JSeparator(SwingConstants.HORIZONTAL));
    box3.add(Box.createGlue());
    box.add(box3);
    GridBagConstraints cons = new GridBagConstraints();
    cons.gridy = y++;
    cons.gridheight = 1;
    cons.gridwidth = GridBagConstraints.REMAINDER;
    cons.fill = GridBagConstraints.BOTH;
    cons.anchor = GridBagConstraints.WEST;
    cons.weightx = 1.0f;
    cons.insets = new Insets(6, 0, 0, 0);
    gridBag.setConstraints(box, cons);
    add(box);
}