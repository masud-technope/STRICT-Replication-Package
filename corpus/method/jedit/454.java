private JTextField addField(JPanel directoryPanel, String label, String defaultText) {
    //new line
    c.gridy++;
    //message
    JTextField field = new JTextField(defaultText);
    c.insets.bottom = 3;
    c.gridx = 0;
    c.gridwidth = 3;
    c.insets.left = 0;
    c.insets.right = 0;
    c.anchor = GridBagConstraints.LINE_START;
    DirVerifier verif = new DirVerifier(directoryPanel, c.clone());
    field.setInputVerifier(verif);
    c.insets.bottom = 12;
    c.gridx = 0;
    c.gridy++;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.LINE_END;
    directoryPanel.add(new JLabel(label, SwingConstants.RIGHT), c);
    c.gridx = 1;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.anchor = GridBagConstraints.CENTER;
    c.insets.left = 12;
    c.insets.right = 12;
    c.weightx = 1.0;
    directoryPanel.add(field, c);
    JButton choose = new JButton("Choose...");
    choose.setRequestFocusEnabled(false);
    choose.addActionListener(new ActionHandler(field));
    c.gridx = 2;
    c.insets.left = 0;
    c.insets.right = 0;
    c.fill = GridBagConstraints.NONE;
    c.weightx = 0;
    directoryPanel.add(choose, c);
    return field;
}