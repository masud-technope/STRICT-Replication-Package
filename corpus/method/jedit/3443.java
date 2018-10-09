//{{{ ErrorListDialog constructor
public  ErrorListDialog(Frame frame, String title, String caption, Vector<ErrorEntry> messages, boolean pluginError) {
    super(frame, title, !pluginError);
    JPanel content = new JPanel(new BorderLayout(12, 12));
    content.setBorder(new EmptyBorder(12, 12, 12, 12));
    setContentPane(content);
    Box iconBox = new Box(BoxLayout.Y_AXIS);
    iconBox.add(new JLabel(UIManager.getIcon("OptionPane.errorIcon")));
    iconBox.add(Box.createGlue());
    content.add(BorderLayout.WEST, iconBox);
    JPanel centerPanel = new JPanel(new BorderLayout());
    JLabel label = new JLabel(caption);
    label.setBorder(new EmptyBorder(0, 0, 6, 0));
    centerPanel.add(BorderLayout.NORTH, label);
    JTextPane errors = new JTextPaneSized();
    errors.setEditable(false);
    errors.setForeground(jEdit.getColorProperty("view.fgColor"));
    errors.setBackground(jEdit.getColorProperty("view.bgColor"));
    errors.setCaretColor(jEdit.getColorProperty("view.caretColor"));
    errors.setSelectionColor(jEdit.getColorProperty("view.selectionColor"));
    StyledDocument doc = errors.getStyledDocument();
    Font plainFont = new JLabel().getFont();
    SimpleAttributeSet plainFontAttrSet = new SimpleAttributeSet();
    StyleConstants.setFontFamily(plainFontAttrSet, plainFont.getFamily());
    SimpleAttributeSet boldFontAttrSet = (SimpleAttributeSet) plainFontAttrSet.clone();
    StyleConstants.setBold(boldFontAttrSet, true);
    for (ErrorEntry entry : messages) {
        try {
            doc.insertString(doc.getLength(), entry.path + ":\n", boldFontAttrSet);
            for (String s : entry.messages) doc.insertString(doc.getLength(), s + "\n", plainFontAttrSet);
        } catch (BadLocationException e) {
        }
    }
    JScrollPane scrollPane = new JScrollPane(errors);
    centerPanel.add(BorderLayout.CENTER, scrollPane);
    content.add(BorderLayout.CENTER, centerPanel);
    Box buttons = new Box(BoxLayout.X_AXIS);
    buttons.add(Box.createGlue());
    ok = new JButton(jEdit.getProperty("common.ok"));
    ok.addActionListener(new ActionHandler());
    if (pluginError) {
        pluginMgr = new JButton(jEdit.getProperty("error-list.plugin-manager"));
        pluginMgr.addActionListener(new ActionHandler());
        buttons.add(pluginMgr);
        buttons.add(Box.createHorizontalStrut(6));
    }
    buttons.add(ok);
    buttons.add(Box.createGlue());
    content.add(BorderLayout.SOUTH, buttons);
    getRootPane().setDefaultButton(ok);
    pack();
    setLocationRelativeTo(frame);
    setVisible(true);
}