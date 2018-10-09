public  PrinterDialog(View owner, PrintRequestAttributeSet attributes, boolean pageSetupOnly) {
    super(owner, Dialog.ModalityType.APPLICATION_MODAL);
    try {
        view = owner;
        this.pageSetupOnly = pageSetupOnly;
        setTitle(pageSetupOnly ? jEdit.getProperty("print.dialog.pageSetupTitle") : jEdit.getProperty("print.dialog.title"));
        if (attributes != null) {
            this.attributes = new HashPrintRequestAttributeSet(attributes);
        } else {
            this.attributes = new HashPrintRequestAttributeSet();
        }
        Attribute jobNameAttr = this.attributes.get(JobName.class);
        if (jobNameAttr != null) {
            jobName = jobNameAttr.toString();
        }
        this.attributes.remove(Destination.class);
        // for debugging
        /* Attribute[] attrs = attributes.toArray();
             * for ( Attribute a : attrs )
             * {
             * Log.log( Log.DEBUG, this, "+++++ before: " + a.getName() + " = " + a );
             * }
             */
        initMessages();
        JPanel contents = new JPanel(new BorderLayout());
        contents.setBorder(BorderFactory.createEmptyBorder(11, 11, 12, 12));
        tabs = new JTabbedPane();
        tabs.setBorder(BorderFactory.createEmptyBorder(0, 0, 11, 0));
        tabs.add(jEdit.getProperty("print.dialog.General", "General"), new GeneralPanel());
        tabs.add(jEdit.getProperty("print.dialog.Page_Setup", "Page Setup"), pageSetupPanel = new PageSetupPanel());
        tabs.add(jEdit.getProperty("print.dialog.Job", "Job"), new JobPanel());
        tabs.add(jEdit.getProperty("print.dialog.Advanced", "Advanced"), new AdvancedPanel());
        tabs.add(jEdit.getProperty("print.dialog.jEdit", "jEdit"), new jEditPanel());
        if (pageSetupOnly) {
            tabs.setSelectedIndex(1);
            tabs.setEnabledAt(0, false);
            tabs.setEnabledAt(1, true);
            tabs.setEnabledAt(2, false);
            tabs.setEnabledAt(3, false);
            tabs.setEnabledAt(4, false);
        }
        contents.add(tabs, BorderLayout.CENTER);
        JButton previewButton = new JButton(jEdit.getProperty("print.dialog.preview", "Preview"));
        previewButton.addActionListener(getPreviewButtonListener());
        JButton okButton = new JButton(jEdit.getProperty("common.ok"));
        okButton.addActionListener(getOkButtonListener());
        JButton cancelButton = new JButton(jEdit.getProperty("common.cancel"));
        cancelButton.addActionListener(getCancelButtonListener());
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 6, 6));
        GenericGUIUtilities.makeSameSize(previewButton, okButton, cancelButton);
        buttonPanel.add(previewButton);
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        contents.add(buttonPanel, BorderLayout.SOUTH);
        setContentPane(contents);
        // auto-select the default printer
        /*
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
            if ( defaultPrintService != null )
            {
                printers.setSelectedValue( defaultPrintService, true );
            }
            else
            {
                printers.setSelectedIndex( 0 );
            }
            */
        // loads some default values if needed
        valueChanged(null);
        // set margin values, need to do this here after the other values have been set
        pageSetupPanel.setDefaultMargins();
        pack();
        // ESC key closes dialog
        getRootPane().registerKeyboardAction( e -> {
            PrinterDialog.this.setVisible(false);
            PrinterDialog.this.dispose();
            canceled = true;
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        setLocationRelativeTo(jEdit.getActiveView().getTextArea());
        setVisible(true);
    } catch (Exception e) {
        e.printStackTrace();
    }
}