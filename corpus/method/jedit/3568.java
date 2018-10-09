//{{{ init() method
private void init(Font font) {
    JPanel content = new JPanel(new BorderLayout());
    content.setBorder(new EmptyBorder(12, 12, 12, 12));
    setContentPane(content);
    JPanel listPanel = new JPanel(new GridLayout(1, 3, 6, 6));
    String[] fonts;
    try {
        fonts = getFontList();
    } catch (Exception e) {
        Log.log(Log.ERROR, this, "Broken Java implementation!");
        Log.log(Log.ERROR, this, e);
        fonts = new String[] { "Broken Java implementation!" };
    }
    JPanel familyPanel = createTextFieldAndListPanel("font-selector.family", familyField = new JTextField(), familyList = new JList<String>(fonts));
    listPanel.add(familyPanel);
    String[] sizes = { "9", "10", "12", "14", "16", "18", "24", "30", "36", "42" };
    JPanel sizePanel = createTextFieldAndListPanel("font-selector.size", sizeField = new JTextField(), sizeList = new JList<String>(sizes));
    listPanel.add(sizePanel);
    String[] styles = { jEdit.getProperty("font-selector.plain"), jEdit.getProperty("font-selector.bold"), jEdit.getProperty("font-selector.italic"), jEdit.getProperty("font-selector.bolditalic") };
    JPanel stylePanel = createTextFieldAndListPanel("font-selector.style", styleField = new JTextField(), styleList = new JList<String>(styles));
    styleField.setEditable(false);
    listPanel.add(stylePanel);
    if (font != null) {
        familyList.setSelectedValue(font.getFamily(), true);
        familyField.setText(font.getFamily());
        sizeList.setSelectedValue(String.valueOf(font.getSize()), true);
        sizeField.setText(String.valueOf(font.getSize()));
        styleList.setSelectedIndex(font.getStyle());
    } else {
        sizeList.setSelectedValue("12", true);
        styleList.setSelectedIndex(Font.PLAIN);
    }
    styleField.setText((String) styleList.getSelectedValue());
    ListHandler listHandler = new ListHandler();
    familyList.addListSelectionListener(listHandler);
    sizeList.addListSelectionListener(listHandler);
    styleList.addListSelectionListener(listHandler);
    content.add(BorderLayout.NORTH, listPanel);
    preview = new JLabel(jEdit.getProperty("font-selector.long-text")) {

        public void paintComponent(Graphics g) {
            if (fontSelector != null)
                fontSelector.setAntiAliasEnabled(g);
            super.paintComponent(g);
        }
    };
    preview.setBorder(new TitledBorder(jEdit.getProperty("font-selector.preview")));
    updatePreview();
    Dimension prefSize = preview.getPreferredSize();
    prefSize.height = 100;
    preview.setPreferredSize(prefSize);
    content.add(BorderLayout.CENTER, preview);
    JPanel buttons = new JPanel();
    buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
    buttons.setBorder(new EmptyBorder(17, 0, 0, 0));
    ok = new JButton(jEdit.getProperty("common.ok"));
    ok.addActionListener(new ActionHandler());
    getRootPane().setDefaultButton(ok);
    cancel = new JButton(jEdit.getProperty("common.cancel"));
    cancel.addActionListener(new ActionHandler());
    GenericGUIUtilities.makeSameSize(ok, cancel);
    buttons.add(Box.createGlue());
    buttons.add(ok);
    buttons.add(Box.createHorizontalStrut(6));
    buttons.add(cancel);
    content.add(BorderLayout.SOUTH, buttons);
    pack();
    setLocationRelativeTo(getParent());
    setVisible(true);
}