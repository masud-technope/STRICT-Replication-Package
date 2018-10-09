//}}}
//{{{ _init() method
@Override
protected void _init() {
    setLayout(new BorderLayout());
    JPanel panel = new JPanel(new BorderLayout(6, 6));
    expandOnInput = new JCheckBox(jEdit.getProperty("options.abbrevs" + ".expandOnInput"), Abbrevs.getExpandOnInput());
    panel.add(expandOnInput, BorderLayout.NORTH);
    JPanel panel2 = new JPanel();
    panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
    panel2.setBorder(new EmptyBorder(0, 0, 6, 0));
    panel2.add(Box.createGlue());
    JLabel label = new JLabel(jEdit.getProperty("options.abbrevs.set"));
    label.setBorder(new EmptyBorder(0, 0, 0, 12));
    panel2.add(label);
    Map<String, Hashtable<String, String>> _modeAbbrevs = Abbrevs.getModeAbbrevs();
    modeAbbrevs = new HashMap<String, AbbrevsModel>();
    Mode[] modes = jEdit.getModes();
    Arrays.sort(modes, new StandardUtilities.StringCompare<Mode>(true));
    String[] sets = new String[modes.length + 1];
    sets[0] = "global";
    for (int i = 0; i < modes.length; i++) {
        String name = modes[i].getName();
        sets[i + 1] = name;
        modeAbbrevs.put(name, new AbbrevsModel(_modeAbbrevs.get(name)));
    }
    setsComboBox = new JComboBox<String>(sets);
    ActionHandler actionHandler = new ActionHandler();
    setsComboBox.addActionListener(actionHandler);
    panel2.add(setsComboBox);
    panel2.add(Box.createGlue());
    panel.add(panel2, BorderLayout.SOUTH);
    add(BorderLayout.NORTH, panel);
    globalAbbrevs = new AbbrevsModel(Abbrevs.getGlobalAbbrevs());
    abbrevsTable = new JTable(globalAbbrevs);
    abbrevsTable.setRowHeight(GenericGUIUtilities.defaultRowHeight());
    abbrevsTable.getColumnModel().getColumn(1).setCellRenderer(new Renderer());
    abbrevsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    abbrevsTable.getTableHeader().setReorderingAllowed(false);
    abbrevsTable.getTableHeader().addMouseListener(new HeaderMouseHandler());
    abbrevsTable.getSelectionModel().addListSelectionListener(new SelectionHandler());
    abbrevsTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    abbrevsTable.addMouseListener(new TableMouseHandler());
    Dimension d = abbrevsTable.getPreferredSize();
    d.height = Math.min(d.height, 200);
    JScrollPane scroller = new JScrollPane(abbrevsTable);
    scroller.setPreferredSize(d);
    add(BorderLayout.CENTER, scroller);
    JPanel buttons = new JPanel();
    buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
    buttons.setBorder(new EmptyBorder(6, 0, 0, 0));
    add = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.abbrevs.add.icon")));
    add.setToolTipText(jEdit.getProperty("options.abbrevs.add"));
    add.addActionListener(actionHandler);
    buttons.add(add);
    remove = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.abbrevs.remove.icon")));
    remove.setToolTipText(jEdit.getProperty("options.abbrevs.remove"));
    remove.addActionListener(actionHandler);
    buttons.add(remove);
    edit = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.abbrevs.edit.icon")));
    edit.setToolTipText(jEdit.getProperty("options.abbrevs.edit"));
    edit.addActionListener(actionHandler);
    buttons.add(edit);
    buttons.add(Box.createGlue());
    add(BorderLayout.SOUTH, buttons);
    setsComboBox.setSelectedIndex(jEdit.getIntegerProperty("options.abbrevs.combobox.index", 0));
    updateEnabled();
}