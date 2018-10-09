private void initialize(Component comp, SyntaxStyle style, String styleName) {
    JPanel content = new JPanel(new BorderLayout(12, 12));
    content.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
    setContentPane(content);
    JPanel panel = new JPanel(new GridLayout(5, 2, 12, 12));
    panel.add(new JLabel(jEdit.getProperty("style-editor.tokenType")));
    panel.add(new JLabel(styleName));
    italics = new JCheckBox(jEdit.getProperty("style-editor.italics"));
    italics.setSelected(style.getFont().isItalic());
    panel.add(italics);
    panel.add(new JLabel());
    bold = new JCheckBox(jEdit.getProperty("style-editor.bold"));
    bold.setSelected(style.getFont().isBold());
    panel.add(bold);
    panel.add(new JLabel());
    Color fg = style.getForegroundColor();
    if (fg == null) {
        fg = jEdit.getActiveView().getEditPane().getTextArea().getPainter().getForeground();
    }
    fgColorCheckBox = new JCheckBox(jEdit.getProperty("style-editor.fgColor"));
    fgColorCheckBox.setSelected(fg != null);
    fgColorCheckBox.addActionListener(this);
    panel.add(fgColorCheckBox);
    fgColor = new ColorWellButton(fg);
    fgColor.setEnabled(fg != null);
    panel.add(fgColor);
    Color bg = style.getBackgroundColor();
    if (bg == null) {
        bg = jEdit.getActiveView().getEditPane().getTextArea().getPainter().getBackground();
    }
    bgColorCheckBox = new JCheckBox(jEdit.getProperty("style-editor.bgColor"));
    bgColorCheckBox.setSelected(bg != null);
    bgColorCheckBox.addActionListener(this);
    panel.add(bgColorCheckBox);
    bgColor = new ColorWellButton(bg);
    bgColor.setEnabled(bg != null);
    panel.add(bgColor);
    content.add(BorderLayout.CENTER, panel);
    Box box = new Box(BoxLayout.X_AXIS);
    box.setBorder(BorderFactory.createEmptyBorder(17, 0, 0, 0));
    ok = new JButton(jEdit.getProperty("common.ok"));
    getRootPane().setDefaultButton(ok);
    ok.addActionListener(this);
    cancel = new JButton(jEdit.getProperty("common.cancel"));
    cancel.addActionListener(this);
    GenericGUIUtilities.makeSameSize(ok, cancel);
    box.add(Box.createGlue());
    box.add(ok);
    box.add(Box.createHorizontalStrut(6));
    box.add(cancel);
    content.add(BorderLayout.SOUTH, box);
    pack();
    setLocationRelativeTo(comp);
    setResizable(false);
    setVisible(true);
}