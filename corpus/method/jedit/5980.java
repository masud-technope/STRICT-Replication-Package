// need 3 subpanels, Job Details, Print Document, and Finishing
public  JobPanel() {
    super();
    // job details panel
    JPanel jobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    jobPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), jEdit.getProperty("print.dialog.Job_Details", "Job Details")), BorderFactory.createEmptyBorder(11, 11, 11, 11)));
    priority = new JComboBox<Priority>();
    priority.addItem(Priority.LOW);
    priority.addItem(Priority.MEDIUM);
    priority.addItem(Priority.HIGH);
    priority.addItem(Priority.URGENT);
    priority.setSelectedItem(Priority.MEDIUM);
    Box priorityBox = Box.createHorizontalBox();
    priorityBox.add(new JLabel(jEdit.getProperty("print.dialog.Priority", "Priority") + ':'));
    priorityBox.add(Box.createHorizontalStrut(6));
    priorityBox.add(priority);
    jobPanel.add(priorityBox);
    // when to print panel
    JPanel printPanel = new JPanel(new VariableGridLayout(VariableGridLayout.FIXED_NUM_COLUMNS, 2, 6, 6));
    printPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), jEdit.getProperty("print.dialog.Print_Document", "Print Document")), BorderFactory.createEmptyBorder(11, 11, 11, 11)));
    // print now
    nowButton = new JRadioButton(jEdit.getProperty("print.dialog.Now", "Now"));
    nowButton.setSelected(true);
    // print later
    atButton = new JRadioButton(jEdit.getProperty("print.dialog.At", "At"));
    atButton.setEnabled(true);
    Calendar calendar = Calendar.getInstance(Locale.getDefault());
    Date initialDate = calendar.getTime();
    calendar.add(Calendar.YEAR, 1);
    Date latestDate = calendar.getTime();
    SpinnerDateModel dateModel = new SpinnerDateModel(initialDate, initialDate, latestDate, Calendar.YEAR);
    when = new JSpinner(dateModel);
    when.setEnabled(true);
    // print hold
    holdButton = new JRadioButton(jEdit.getProperty("print.dialog.On_Hold", "On Hold"));
    holdButton.setEnabled(true);
    new MyButtonGroup(nowButton, atButton, holdButton);
    printPanel.add(nowButton);
    printPanel.add(Box.createGlue());
    printPanel.add(atButton);
    printPanel.add(when);
    printPanel.add(holdButton);
    printPanel.add(Box.createGlue());
    JPanel content = new JPanel(new VariableGridLayout(VariableGridLayout.FIXED_NUM_COLUMNS, 2, 6, 6));
    content.add(jobPanel);
    content.add(printPanel);
    add(content, BorderLayout.NORTH);
    // add listeners
    atButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            when.setEnabled(atButton.isSelected());
        }
    });
}