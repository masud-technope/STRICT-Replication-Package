//}}}
//{{{ createButtonsPanel() method
private Box createButtonsPanel() {
    Box box = new Box(BoxLayout.Y_AXIS);
    ButtonActionHandler actionHandler = new ButtonActionHandler();
    box.add(Box.createVerticalStrut(12));
    JPanel grid = new JPanel(new GridLayout(5, 1, 0, 12));
    findBtn = new JButton(jEdit.getProperty("search.findBtn"));
    getRootPane().setDefaultButton(findBtn);
    grid.add(findBtn);
    findBtn.addActionListener(actionHandler);
    replaceBtn = new JButton(jEdit.getProperty("search.replaceBtn", "Replace"));
    replaceBtn.setMnemonic(jEdit.getProperty("search.replaceBtn.mnemonic", "p").charAt(0));
    grid.add(replaceBtn);
    replaceBtn.addActionListener(actionHandler);
    replaceAndFindBtn = new JButton(jEdit.getProperty("search.replaceAndFindBtn"));
    replaceAndFindBtn.setMnemonic(jEdit.getProperty("search.replaceAndFindBtn.mnemonic", "R").charAt(0));
    grid.add(replaceAndFindBtn);
    replaceAndFindBtn.addActionListener(actionHandler);
    replaceAllBtn = new JButton(jEdit.getProperty("search.replaceAllBtn"));
    replaceAllBtn.setMnemonic(jEdit.getProperty("search.replaceAllBtn.mnemonic", "a").charAt(0));
    grid.add(replaceAllBtn);
    replaceAllBtn.addActionListener(actionHandler);
    closeBtn = new JButton(jEdit.getProperty("common.close"));
    grid.add(closeBtn);
    closeBtn.addActionListener(actionHandler);
    grid.setMaximumSize(grid.getPreferredSize());
    box.add(grid);
    box.add(Box.createGlue());
    return box;
}