public  FontList() {
    int i = 0;
    setLayout(new BorderLayout());
    /* Label. */
    JLabel l = new JLabel(jEdit.getProperty("options.textarea.fontSubstList"));
    /* Substitution font list. */
    Font f;
    fontsModel = new DefaultListModel<Font>();
    fonts = new JList<Font>(fontsModel);
    fonts.setCellRenderer(new FontItemRenderer());
    while ((f = jEdit.getFontProperty("view.fontSubstList." + i)) != null) {
        fontsModel.addElement(f);
        i++;
    }
    /* Right-side button box. */
    Box buttons = new Box(BoxLayout.Y_AXIS);
    add = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.context.add.icon")));
    add.setToolTipText(jEdit.getProperty("common.add"));
    add.addActionListener(this);
    buttons.add(add);
    buttons.add(Box.createVerticalStrut(2));
    remove = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.context.remove.icon")));
    remove.setToolTipText(jEdit.getProperty("common.remove"));
    remove.addActionListener(this);
    buttons.add(remove);
    buttons.add(Box.createVerticalStrut(2));
    up = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.context.moveUp.icon")));
    up.setToolTipText(jEdit.getProperty("common.moveUp"));
    up.addActionListener(this);
    buttons.add(up);
    buttons.add(Box.createVerticalStrut(2));
    down = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.context.moveDown.icon")));
    down.setToolTipText(jEdit.getProperty("common.moveDown"));
    down.addActionListener(this);
    buttons.add(down);
    buttons.add(Box.createGlue());
    add(BorderLayout.NORTH, l);
    add(BorderLayout.CENTER, new JScrollPane(fonts));
    add(BorderLayout.EAST, buttons);
}