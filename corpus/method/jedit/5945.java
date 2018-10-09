// added the PrintRangeType attribute to handle these.
public  GeneralPanel() {
    super();
    printers = new JList<PrintService>(getPrintServices());
    printers.setCellRenderer(new PrintServiceCellRenderer());
    printers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JPanel rangePanel = new JPanel(new GridLayout(4, 2, 6, 6));
    rangePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), jEdit.getProperty("print.dialog.Range", "Range")), BorderFactory.createEmptyBorder(11, 11, 11, 11)));
    allPages = new JRadioButton(jEdit.getProperty("print.dialog.All_pages", "All pages"));
    allPages.setSelected(true);
    pages = new JRadioButton(jEdit.getProperty("print.dialog.Pages", "Pages") + ':');
    pagesField = new JTextField();
    pagesField.setEnabled(false);
    currentPage = new JRadioButton(jEdit.getProperty("print.dialog.Current_page", "Current page"));
    selection = new JRadioButton(jEdit.getProperty("print.dialog.Selection", "Selection"));
    new MyButtonGroup(allPages, pages, currentPage, selection);
    Box pagesBox = Box.createHorizontalBox();
    pagesBox.add(pages);
    pagesBox.add(Box.createHorizontalStrut(6));
    pagesBox.add(pagesField);
    rangePanel.add(allPages);
    rangePanel.add(Box.createGlue());
    rangePanel.add(pagesBox);
    rangePanel.add(Box.createGlue());
    rangePanel.add(currentPage);
    rangePanel.add(Box.createGlue());
    rangePanel.add(selection);
    JPanel copiesPanel = new JPanel(new GridLayout(3, 2, 6, 6));
    copiesPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), jEdit.getProperty("print.dialog.Copies", "Copies")), BorderFactory.createEmptyBorder(11, 11, 11, 11)));
    JLabel copiesLabel = new JLabel(jEdit.getProperty("print.dialog.Copies", "Copies" + ':'));
    copies = new JSpinner(new SpinnerNumberModel(1, 1, 999, 1));
    collate = new JCheckBox(jEdit.getProperty("print.dialog.Collate", "Collate"));
    collate.setSelected(false);
    collate.setEnabled(false);
    reverse = new JCheckBox(jEdit.getProperty("print.dialog.Reverse", "Reverse"));
    reverse.setSelected(false);
    reverse.setEnabled(true);
    copiesPanel.add(copiesLabel);
    copiesPanel.add(copies);
    copiesPanel.add(collate);
    copiesPanel.add(Box.createGlue());
    copiesPanel.add(reverse);
    JPanel content = new JPanel(new BorderLayout());
    JPanel top = new JPanel(new BorderLayout());
    JPanel bottom = new JPanel(new GridLayout(1, 2, 6, 6));
    top.add(new JScrollPane(printers), BorderLayout.CENTER);
    bottom.add(rangePanel);
    bottom.add(copiesPanel);
    content.add(top, BorderLayout.CENTER);
    content.add(bottom, BorderLayout.SOUTH);
    add(content);
    // install listeners
    printers.addListSelectionListener(PrinterDialog.this);
    allPages.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            pagesField.setEnabled(pages.isSelected());
        }
    });
    pages.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            pagesField.setEnabled(pages.isSelected());
        }
    });
    copies.addChangeListener(new ChangeListener() {

        public void stateChanged(ChangeEvent e) {
            JSpinner spinner = (JSpinner) e.getSource();
            int value = (int) spinner.getValue();
            collate.setEnabled(value > 1);
            collate.setSelected(value > 1);
        }
    });
    PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
    // choose last used printer first, default printer if no last used, or first
    // item in print service list otherwise
    String lastUsedPrinterName = jEdit.getProperty("print.lastUsedPrinter");
    if (lastUsedPrinterName != null) {
        ListModel<PrintService> lm = printers.getModel();
        for (int i = 0; i < lm.getSize(); i++) {
            PrintService ps = lm.getElementAt(i);
            if (lastUsedPrinterName.equals(ps.getName())) {
                printers.setSelectedValue(ps, true);
                selectedPrintService = ps;
                break;
            }
        }
    } else if (defaultPrintService != null) {
        printers.setSelectedValue(defaultPrintService, true);
        selectedPrintService = defaultPrintService;
    } else {
        selectedPrintService = printers.getModel().getElementAt(0);
    }
}