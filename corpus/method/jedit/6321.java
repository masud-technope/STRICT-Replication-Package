//}}}
//{{{ createFieldPanel() method
private JPanel createFieldPanel() {
    JPanel fieldPanel = new JPanel(new GridBagLayout());
    fieldPanel.setBorder(new EmptyBorder(0, 0, 12, 12));
    GridBagConstraints cons = new GridBagConstraints();
    cons.fill = GridBagConstraints.BOTH;
    cons.gridy = 0;
    cons.gridwidth = 2;
    createFindLabelAndField(fieldPanel, cons);
    createReplaceLabelAndField(fieldPanel, cons);
    return fieldPanel;
}