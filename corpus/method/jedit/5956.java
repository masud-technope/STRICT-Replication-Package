private ActionListener getOkButtonListener() {
    return new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            // check margins and so on
            String checkMarginsMessage = pageSetupPanel.recalculate();
            if (checkMarginsMessage != null) {
                JOptionPane.showMessageDialog(PrinterDialog.this, checkMarginsMessage, jEdit.getProperty("print-error.title"), JOptionPane.ERROR_MESSAGE);
                return;
            }
            // gather all the attributes from the tabs
            for (int i = 0; i < tabs.getTabCount(); i++) {
                PrinterPanel panel = (PrinterPanel) tabs.getComponentAt(i);
                AttributeSet panelAttributes = panel.getAttributes();
                if (panelAttributes != null) {
                    PrinterDialog.this.attributes.addAll(panelAttributes);
                }
            }
            // adjust the print range to filter based on odd/even pages
            PageRanges pr = (PageRanges) PrinterDialog.this.attributes.get(PageRanges.class);
            try {
                PageRanges mergedRanges = mergeRanges(pr);
                if (mergedRanges != null) {
                    PrinterDialog.this.attributes.add(mergedRanges);
                }
            } catch (PrintException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(PrinterDialog.this, jEdit.getProperty("print-error.message", new String[] { e.getMessage() }), jEdit.getProperty("print-error.title"), JOptionPane.ERROR_MESSAGE);
                return;
            }
            // if printing to a file, get the filename to use
            if (!pageSetupOnly && getPrintService() instanceof StreamPrintService) {
                // create default filename
                String filename = "out";
                if (jobName != null) {
                    File f = new File(jobName);
                    filename = f.getName();
                }
                filename = new StringBuilder(filename).append(".ps").toString();
                File initialFile = new File(System.getProperty("user.home"), filename);
                // show file chooser
                String[] files = GUIUtilities.showVFSFileDialog(PrinterDialog.this, view, initialFile.getAbsolutePath(), VFSBrowser.SAVE_DIALOG, false);
                if (files != null && files.length > 0) {
                    File file = new File(files[0]);
                    selectedPrintService = getPostscriptPrintService(file);
                } else {
                    return;
                }
            }
            // for debugging
            /*
                 * Attribute[] attrs = PrinterDialog.this.attributes.toArray();
                 * for ( Attribute a : attrs )
                 * {
                 * Log.log( Log.DEBUG, this, "+++++ after: " + a.getName() + " = " + a );
                 * }
                 */
            PrinterDialog.this.setVisible(false);
            PrinterDialog.this.dispose();
        }
    };
}