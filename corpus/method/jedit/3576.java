//}}}
//{{{ createTextFieldAndListPanel() method
private static JPanel createTextFieldAndListPanel(String label, JTextField textField, JList list) {
    GridBagLayout layout = new GridBagLayout();
    JPanel panel = new JPanel(layout);
    GridBagConstraints cons = new GridBagConstraints();
    cons.gridx = cons.gridy = 0;
    cons.gridwidth = cons.gridheight = 1;
    cons.fill = GridBagConstraints.BOTH;
    cons.weightx = 1.0f;
    JLabel _label = new JLabel(jEdit.getProperty(label));
    layout.setConstraints(_label, cons);
    panel.add(_label);
    cons.gridy = 1;
    Component vs = Box.createVerticalStrut(6);
    layout.setConstraints(vs, cons);
    panel.add(vs);
    cons.gridy = 2;
    layout.setConstraints(textField, cons);
    panel.add(textField);
    cons.gridy = 3;
    vs = Box.createVerticalStrut(6);
    layout.setConstraints(vs, cons);
    panel.add(vs);
    cons.gridy = 4;
    cons.gridheight = GridBagConstraints.REMAINDER;
    cons.weighty = 1.0f;
    JScrollPane scroller = new JScrollPane(list);
    layout.setConstraints(scroller, cons);
    panel.add(scroller);
    return panel;
}