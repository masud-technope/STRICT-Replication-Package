//}}}
//{{{ Protected members
//{{{ _init() method
protected void _init() {
    setLayout(new BorderLayout());
    colorsModel = new BrowserColorsModel();
    colorsTable = new JTable(colorsModel);
    colorsTable.setRowHeight(GenericGUIUtilities.defaultRowHeight());
    colorsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    colorsTable.getTableHeader().setReorderingAllowed(false);
    colorsTable.addMouseListener(new MouseHandler());
    colorsTable.getSelectionModel().addListSelectionListener(new SelectionHandler());
    TableColumnModel tcm = colorsTable.getColumnModel();
    tcm.getColumn(1).setCellRenderer(new BrowserColorsModel.ColorRenderer());
    Dimension d = colorsTable.getPreferredSize();
    d.height = Math.min(d.height, 200);
    JScrollPane scroller = new JScrollPane(colorsTable);
    scroller.setPreferredSize(d);
    add(BorderLayout.CENTER, scroller);
    JPanel buttons = new JPanel();
    buttons.setBorder(new EmptyBorder(3, 0, 0, 0));
    buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
    ActionHandler actionHandler = new ActionHandler();
    add = new RolloverButton(GUIUtilities.loadIcon("Plus.png"));
    add.setToolTipText(jEdit.getProperty("common.add"));
    add.addActionListener(actionHandler);
    buttons.add(add);
    buttons.add(Box.createHorizontalStrut(6));
    remove = new RolloverButton(GUIUtilities.loadIcon("Minus.png"));
    remove.setToolTipText(jEdit.getProperty("common.remove"));
    remove.addActionListener(actionHandler);
    buttons.add(remove);
    buttons.add(Box.createHorizontalStrut(6));
    moveUp = new RolloverButton(GUIUtilities.loadIcon("ArrowU.png"));
    moveUp.setToolTipText(jEdit.getProperty("common.moveUp"));
    moveUp.addActionListener(actionHandler);
    buttons.add(moveUp);
    buttons.add(Box.createHorizontalStrut(6));
    moveDown = new RolloverButton(GUIUtilities.loadIcon("ArrowD.png"));
    moveDown.setToolTipText(jEdit.getProperty("common.moveDown"));
    moveDown.addActionListener(actionHandler);
    buttons.add(moveDown);
    buttons.add(Box.createGlue());
    add(BorderLayout.SOUTH, buttons);
    updateEnabled();
}