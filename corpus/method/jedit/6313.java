//}}}
//{{{ createFindLabelAndField() method
private void createFindLabelAndField(JPanel fieldPanel, GridBagConstraints cons) {
    JLabel label = new JLabel(jEdit.getProperty("search.find"));
    label.setDisplayedMnemonic(jEdit.getProperty("search.find.mnemonic").charAt(0));
    find = new HistoryTextArea("find");
    find.setName("find");
    find.setColumns(25);
    find.setToolTipText(jEdit.getProperty("search.find.tooltip"));
    label.setToolTipText(jEdit.getProperty("search.find.tooltip"));
    label.setLabelFor(find);
    label.setBorder(new EmptyBorder(12, 0, 2, 0));
    cons.gridx = 0;
    cons.weightx = 0.0;
    cons.weighty = 0.0;
    fieldPanel.add(label, cons);
    cons.gridy++;
    cons.weightx = 1.0;
    cons.weighty = 1.0;
    fieldPanel.add(new JScrollPane(find), cons);
    cons.gridy++;
}