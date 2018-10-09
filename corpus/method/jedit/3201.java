//{{{ ContextAddDialog constructor
public  ContextAddDialog(Component comp, ActionContext actionContext) {
    super(GenericGUIUtilities.getParentDialog(comp), jEdit.getProperty("options.context.add.title"), true);
    JPanel content = new JPanel(new BorderLayout());
    content.setBorder(new EmptyBorder(12, 12, 12, 12));
    setContentPane(content);
    ActionHandler actionHandler = new ActionHandler();
    ButtonGroup grp = new ButtonGroup();
    JPanel typePanel = new JPanel(new GridLayout(3, 1, 6, 6));
    typePanel.setBorder(new EmptyBorder(0, 0, 6, 0));
    typePanel.add(new JLabel(jEdit.getProperty("options.context.add.caption")));
    separator = new JRadioButton(jEdit.getProperty("options.context" + ".add.separator"));
    separator.addActionListener(actionHandler);
    grp.add(separator);
    typePanel.add(separator);
    action = new JRadioButton(jEdit.getProperty("options.context" + ".add.action"));
    action.addActionListener(actionHandler);
    grp.add(action);
    action.setSelected(true);
    typePanel.add(action);
    content.add(BorderLayout.NORTH, typePanel);
    JPanel actionPanel = new JPanel(new BorderLayout(6, 6));
    ActionSet[] actionsList = actionContext.getActionSets();
    Collection<ActionSet> actionSets = new TreeSet<ActionSet>();
    String lastSelectionLabel = jEdit.getProperty(CONTEXT_ADD_DIALOG_LAST_SELECTION);
    for (ActionSet actionSet : actionsList) {
        if (actionSet.getActionCount() != 0) {
            actionSets.add(actionSet);
        }
    }
    int selectionIndex = 0;
    int i = 0;
    for (ActionSet actionSet : actionSets) {
        if (actionSet.getLabel().equals(lastSelectionLabel)) {
            selectionIndex = i;
            break;
        }
        i++;
    }
    combo = new JComboBox<ActionSet>(actionSets.toArray(new ActionSet[actionSets.size()]));
    combo.setSelectedIndex(selectionIndex);
    combo.addActionListener(actionHandler);
    actionPanel.add(BorderLayout.NORTH, combo);
    list = new JList<MenuItem>();
    list.setVisibleRowCount(8);
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    actionPanel.add(BorderLayout.CENTER, new JScrollPane(list));
    content.add(BorderLayout.CENTER, actionPanel);
    JPanel southPanel = new JPanel();
    southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
    southPanel.setBorder(new EmptyBorder(17, 0, 0, 0));
    ok = new JButton(jEdit.getProperty("common.ok"));
    ok.addActionListener(actionHandler);
    getRootPane().setDefaultButton(ok);
    cancel = new JButton(jEdit.getProperty("common.cancel"));
    cancel.addActionListener(actionHandler);
    GenericGUIUtilities.makeSameSize(ok, cancel);
    southPanel.add(Box.createGlue());
    southPanel.add(ok);
    southPanel.add(Box.createHorizontalStrut(6));
    southPanel.add(cancel);
    content.add(BorderLayout.SOUTH, southPanel);
    updateList();
    pack();
    setLocationRelativeTo(GenericGUIUtilities.getParentDialog(comp));
    setVisible(true);
}