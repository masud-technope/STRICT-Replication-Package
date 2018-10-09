//}}}
//{{{ init()
private void init() {
    setTitle(jEdit.getProperty("colorChooser.title"));
    JPanel contents = new JPanel();
    contents.setLayout(new BorderLayout());
    contents.setBorder(BorderFactory.createEmptyBorder(12, 12, 11, 11));
    colorChooser = new JColorChooser(initialColor);
    contents.add(colorChooser, BorderLayout.CENTER);
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(17, 0, 0, 0));
    JButton ok = new JButton(jEdit.getProperty("common.ok"));
    ok.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            ColorChooserDialog.this.setVisible(false);
            ColorChooserDialog.this.dispose();
        }
    });
    getRootPane().setDefaultButton(ok);
    JButton cancel = new JButton(jEdit.getProperty("common.cancel"));
    cancel.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            ColorChooserDialog.this.setVisible(false);
            ColorChooserDialog.this.dispose();
        }
    });
    JButton reset = new JButton(jEdit.getProperty("common.reset"));
    reset.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            colorChooser.setColor(initialColor);
        }
    });
    GenericGUIUtilities.makeSameSize(ok, cancel, reset);
    buttonPanel.add(Box.createGlue());
    buttonPanel.add(ok);
    buttonPanel.add(Box.createHorizontalStrut(6));
    buttonPanel.add(cancel);
    buttonPanel.add(Box.createHorizontalStrut(6));
    buttonPanel.add(reset);
    contents.add(buttonPanel, BorderLayout.SOUTH);
    setContentPane(contents);
    pack();
    setLocationRelativeTo(getParent());
    setVisible(true);
}