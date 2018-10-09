public  PageSetupPanel() {
    super();
    JPanel layoutPanel = new JPanel(new VariableGridLayout(VariableGridLayout.FIXED_NUM_COLUMNS, 2, 6, 6));
    layoutPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), jEdit.getProperty("print.dialog.Layout", "Layout")), BorderFactory.createEmptyBorder(11, 11, 11, 11)));
    sides = new JComboBox<Sides>();
    sides.setEnabled(false);
    sides.setRenderer(new SidesCellRenderer());
    pagesPerSide = new JComboBox<NumberUp>();
    pagesPerSide.setEnabled(false);
    // disable this when pagesPerSide is 1
    pageOrdering = new JComboBox<PresentationDirection>();
    pageOrdering.setEnabled(false);
    onlyPrint = new JComboBox<String>();
    // ALL
    onlyPrint.addItem(jEdit.getProperty("print.dialog.All_sheets", "All sheets"));
    // ODD
    onlyPrint.addItem(jEdit.getProperty("print.dialog.Odd_sheets", "Odd sheets"));
    // EVEN
    onlyPrint.addItem(jEdit.getProperty("print.dialog.Even_sheets", "Even sheets"));
    onlyPrint.setSelectedIndex(0);
    onlyPrint.setEnabled(true);
    // TODO: scale?
    layoutPanel.add(new JLabel(jEdit.getProperty("print.dialog.Two-sided", "Two-sided") + ':'));
    layoutPanel.add(sides);
    layoutPanel.add(new JLabel(jEdit.getProperty("print.dialog.Pages_per_side", "Pages per side") + ':'));
    layoutPanel.add(pagesPerSide);
    layoutPanel.add(new JLabel(jEdit.getProperty("print.dialog.Page_ordering", "Page ordering") + ':'));
    layoutPanel.add(pageOrdering);
    layoutPanel.add(new JLabel(jEdit.getProperty("print.dialog.Only_print", "Only print") + ':'));
    layoutPanel.add(onlyPrint);
    JPanel paperPanel = new JPanel(new VariableGridLayout(VariableGridLayout.FIXED_NUM_COLUMNS, 2, 6, 6));
    paperPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), jEdit.getProperty("print.dialog.Paper", "Paper")), BorderFactory.createEmptyBorder(11, 11, 11, 11)));
    paperSource = new JComboBox<MediaTray>();
    paperSource.setEnabled(false);
    outputTray = new JComboBox<String>();
    outputTray.setEnabled(false);
    paperSize = new JComboBox<String>();
    paperSize.setEnabled(false);
    orientation = new JComboBox<OrientationRequested>();
    orientation.setEnabled(false);
    orientation.setRenderer(new OrientationCellRenderer());
    paperPanel.add(new JLabel(jEdit.getProperty("print.dialog.Paper_source", "Paper source") + ':'));
    paperPanel.add(paperSource);
    paperPanel.add(new JLabel(jEdit.getProperty("print.dialog.Output_tray", "Output tray") + ':'));
    paperPanel.add(outputTray);
    paperPanel.add(new JLabel(jEdit.getProperty("print.dialog.Paper_size", "Paper size") + ':'));
    paperPanel.add(paperSize);
    paperPanel.add(new JLabel(jEdit.getProperty("print.dialog.Orientation", "Orientation") + ':'));
    paperPanel.add(orientation);
    JPanel marginPanel = new JPanel(new VariableGridLayout(VariableGridLayout.FIXED_NUM_COLUMNS, 2, 6, 6));
    marginPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), jEdit.getProperty("print.dialog.Margins", "Margins")), BorderFactory.createEmptyBorder(11, 11, 11, 11)));
    boolean unitIsMM = getUnits() == MediaPrintableArea.MM;
    String topMargin = jEdit.getProperty("print.topMargin", unitIsMM ? "25" : "1.0");
    String leftMargin = jEdit.getProperty("print.leftMargin", unitIsMM ? "25" : "1.0");
    String rightMargin = jEdit.getProperty("print.rightMargin", unitIsMM ? "25" : "1.0");
    String bottomMargin = jEdit.getProperty("print.bottomMargin", unitIsMM ? "25" : "1.0");
    topMarginField = new NumericTextField(topMargin, true, unitIsMM);
    leftMarginField = new NumericTextField(leftMargin, true, unitIsMM);
    rightMarginField = new NumericTextField(rightMargin, true, unitIsMM);
    bottomMarginField = new NumericTextField(bottomMargin, true, unitIsMM);
    String unitsLabel = unitIsMM ? " (mm)" : " (in)";
    marginPanel.add(new JLabel(jEdit.getProperty("print.dialog.Top", "Top") + unitsLabel));
    marginPanel.add(topMarginField);
    marginPanel.add(new JLabel(jEdit.getProperty("print.dialog.Left", "Left") + unitsLabel));
    marginPanel.add(leftMarginField);
    marginPanel.add(new JLabel(jEdit.getProperty("print.dialog.Right", "Right") + unitsLabel));
    marginPanel.add(rightMarginField);
    marginPanel.add(new JLabel(jEdit.getProperty("print.dialog.Bottom", "Bottom") + unitsLabel));
    marginPanel.add(bottomMarginField);
    JPanel finishingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    finishingPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), jEdit.getProperty("print.dialog.Finishing", "Finishing")), BorderFactory.createEmptyBorder(11, 11, 11, 11)));
    finishing = new JComboBox<Finishings>();
    finishing.setEnabled(false);
    finishing.setRenderer(new FinishingCellRenderer());
    Box finishingBox = Box.createHorizontalBox();
    finishingBox.add(new JLabel(jEdit.getProperty("print.dialog.Finishing", "Finishing") + ':'));
    finishingBox.add(Box.createHorizontalStrut(6));
    finishingBox.add(finishing);
    finishingPanel.add(finishingBox);
    JPanel content = new JPanel(new VariableGridLayout(VariableGridLayout.FIXED_NUM_COLUMNS, 2, 6, 6));
    content.add(layoutPanel);
    content.add(paperPanel);
    content.add(marginPanel);
    content.add(finishingPanel);
    add(content);
    // add listeners
    pagesPerSide.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            NumberUp nu = (NumberUp) pagesPerSide.getSelectedItem();
            if (nu != null && nu.getValue() == 1) {
                pageOrdering.setEnabled(false);
            }
        }
    });
    paperSize.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            PageSetupPanel.this.setDefaultMargins();
        }
    });
    orientation.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            PageSetupPanel.this.setDefaultMargins();
        }
    });
}