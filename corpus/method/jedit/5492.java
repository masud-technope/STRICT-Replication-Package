//{{{ WidgetSelectionDialog constructors
 WidgetSelectionDialog(Component comp, String value) {
    super(GenericGUIUtilities.getParentDialog(comp), jEdit.getProperty("options.status.edit.title"), true);
    ButtonGroup buttonGroup = new ButtonGroup();
    labelRadio = new JRadioButton(jEdit.getProperty("options.status.edit.labelRadioButton"));
    widgetRadio = new JRadioButton(jEdit.getProperty("options.status.edit.widgetRadioButton"));
    buttonGroup.add(labelRadio);
    buttonGroup.add(widgetRadio);
    labelLabel = new JLabel(jEdit.getProperty("options.status.edit.labelLabel"));
    labelField = new JTextField();
    widgetLabel = new JLabel(jEdit.getProperty("options.status.edit.widgetLabel"));
    String[] allWidgets = ServiceManager.getServiceNames("org.gjt.sp.jedit.gui.statusbar.StatusWidgetFactory");
    Arrays.sort(allWidgets);
    boolean valueIsWidget = value != null && Arrays.binarySearch(allWidgets, value) >= 0;
    Vector<String> widgets = new Vector<String>(allWidgets.length);
    Set<String> usedWidget = new HashSet<String>(listModel.getSize());
    for (int i = 0; i < listModel.getSize(); i++) {
        usedWidget.add((String) listModel.get(i));
    }
    for (String widget : allWidgets) {
        if (!usedWidget.contains(widget) || (valueIsWidget && widget.equals(value)))
            widgets.add(widget);
    }
    widgetCombo = new JComboBox<String>(widgets);
    widgetCombo.setRenderer(new WidgetListCellRenderer());
    ActionHandler actionHandler = new ActionHandler();
    labelRadio.addActionListener(actionHandler);
    widgetRadio.addActionListener(actionHandler);
    //{{{ south panel
    JPanel southPanel = new JPanel();
    southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
    southPanel.setBorder(new EmptyBorder(12, 0, 0, 0));
    southPanel.add(Box.createGlue());
    ok = new JButton(jEdit.getProperty("common.ok"));
    ok.addActionListener(actionHandler);
    getRootPane().setDefaultButton(ok);
    southPanel.add(ok);
    southPanel.add(Box.createHorizontalStrut(6));
    cancel = new JButton(jEdit.getProperty("common.cancel"));
    cancel.addActionListener(actionHandler);
    southPanel.add(cancel);
    southPanel.add(Box.createGlue());
    //}}}
    labelField.setEnabled(false);
    widgetRadio.setSelected(true);
    JPanel content = new JPanel(new BorderLayout());
    content.setBorder(new EmptyBorder(12, 12, 12, 12));
    setContentPane(content);
    JPanel center = new JPanel();
    center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
    center.add(labelRadio);
    JPanel p = new JPanel(new BorderLayout());
    p.add(labelLabel, BorderLayout.WEST);
    p.add(labelField);
    center.add(p);
    center.add(widgetRadio);
    p = new JPanel(new BorderLayout());
    p.add(widgetLabel, BorderLayout.WEST);
    p.add(widgetCombo);
    if (widgets.isEmpty()) {
        labelRadio.setSelected(true);
        widgetRadio.setEnabled(false);
        widgetLabel.setEnabled(false);
        widgetCombo.setEnabled(false);
    }
    center.add(p);
    if (valueIsWidget) {
        widgetRadio.setSelected(true);
        widgetCombo.setSelectedItem(value);
    } else {
        labelRadio.setSelected(true);
        labelField.setText(value);
        labelField.setEnabled(true);
        widgetCombo.setEnabled(false);
    }
    getContentPane().add(center, BorderLayout.CENTER);
    getContentPane().add(southPanel, BorderLayout.SOUTH);
    pack();
    setLocationRelativeTo(GenericGUIUtilities.getParentDialog(comp));
    setVisible(true);
}