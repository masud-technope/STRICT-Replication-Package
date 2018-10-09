/**
	 * Shows the printer dialog with the page setup tab active, other tabs inactive.
	 * @param view The parent view for the dialog.
	 */
public static void pageSetup(View view) {
    loadPrintSpec();
    PrinterDialog printerDialog = new PrinterDialog(view, format, true);
    if (!printerDialog.isCanceled()) {
        format = printerDialog.getAttributes();
        savePrintSpec();
        EditBus.send(new PropertiesChanged(null));
    }
}