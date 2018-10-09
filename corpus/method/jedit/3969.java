//}}}
//{{{ createFieldPanel() method
private JPanel createFieldPanel() {
    GridBagLayout layout = new GridBagLayout();
    JPanel panel = new JPanel(layout);
    GridBagConstraints cons = new GridBagConstraints();
    cons.insets = new Insets(0, 0, 6, 6);
    cons.gridwidth = cons.gridheight = 1;
    cons.gridx = cons.gridy = 0;
    cons.fill = GridBagConstraints.BOTH;
    JLabel label = new JLabel(jEdit.getProperty("selectlinerange.start"), SwingConstants.RIGHT);
    layout.setConstraints(label, cons);
    panel.add(label);
    startField = new NumericTextField("0", 10, true);
    FocusListener focusListener = new FocusListener() {

        public void focusGained(FocusEvent fe) {
            ((JTextField) fe.getSource()).selectAll();
        }

        public void focusLost(FocusEvent fe) {
            JTextField source = (JTextField) fe.getSource();
            source.setCaretPosition(source.getText().length());
        }
    };
    startField.addFocusListener(focusListener);
    cons.gridx = 1;
    cons.weightx = 1.0f;
    layout.setConstraints(startField, cons);
    panel.add(startField);
    label = new JLabel(jEdit.getProperty("selectlinerange.end"), SwingConstants.RIGHT);
    cons.gridx = 0;
    cons.weightx = 0.0f;
    cons.gridy = 1;
    layout.setConstraints(label, cons);
    panel.add(label);
    endField = new NumericTextField("0", 10, true);
    endField.addFocusListener(focusListener);
    cons.gridx = 1;
    cons.weightx = 1.0f;
    layout.setConstraints(endField, cons);
    panel.add(endField);
    return panel;
}