//}}}
//{{{ createReplaceLabelAndField() method
private void createReplaceLabelAndField(JPanel fieldPanel, GridBagConstraints cons) {
    JLabel label = new JLabel(jEdit.getProperty("search.replace"));
    label.setDisplayedMnemonic(jEdit.getProperty("search.replace.mnemonic").charAt(0));
    label.setBorder(new EmptyBorder(12, 0, 0, 0));
    cons.gridx = 0;
    cons.weightx = 0.0;
    cons.weighty = 0.0;
    fieldPanel.add(label, cons);
    cons.gridy++;
    cons.gridx = 0;
    cons.gridwidth = 2;
    cons.insets = new Insets(0, 0, 0, 0);
    replace = new HistoryTextArea("replace");
    replace.setName("replace");
    replace.setToolTipText(jEdit.getProperty("search.find.tooltip"));
    label.setLabelFor(replace);
    cons.gridx = 0;
    cons.gridy++;
    cons.weightx = 1.0;
    cons.weighty = 1.0;
    fieldPanel.add(new JScrollPane(replace), cons);
    cons.gridy++;
    ButtonGroup grp = new ButtonGroup();
    ReplaceActionHandler replaceActionHandler = new ReplaceActionHandler();
    stringReplace = new JRadioButton(jEdit.getProperty("search.string-replace-btn"));
    stringReplace.addActionListener(replaceActionHandler);
    grp.add(stringReplace);
    cons.gridwidth = 1;
    fieldPanel.add(stringReplace, cons);
    cons.gridx++;
    cons.insets = new Insets(0, 12, 0, 0);
    beanShellReplace = new JRadioButton(jEdit.getProperty("search.beanshell-replace-btn"));
    beanShellReplace.addActionListener(replaceActionHandler);
    grp.add(beanShellReplace);
    fieldPanel.add(beanShellReplace, cons);
    cons.gridy++;
}