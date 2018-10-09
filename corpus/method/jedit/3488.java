//}}}
//{{{ createSouthPanel() method
public JPanel createSouthPanel() {
    ButtonActionHandler actionHandler = new ButtonActionHandler();
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(17, 0, 0, 0));
    okButton = new JButton(jEdit.getProperty("fileprop.okBtn"));
    okButton.addActionListener(actionHandler);
    getRootPane().setDefaultButton(okButton);
    cancelButton = new JButton(jEdit.getProperty("fileprop.cancelBtn"));
    cancelButton.addActionListener(actionHandler);
    GenericGUIUtilities.makeSameSize(okButton, cancelButton);
    panel.add(Box.createGlue());
    panel.add(okButton);
    panel.add(Box.createHorizontalStrut(6));
    panel.add(cancelButton);
    return panel;
}