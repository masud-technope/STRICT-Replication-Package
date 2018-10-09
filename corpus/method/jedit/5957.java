private ActionListener getPreviewButtonListener() {
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
            new PrintPreview(view, view.getBuffer(), PrinterDialog.this.getPrintService(), PrinterDialog.this.attributes);
        }
    };
}