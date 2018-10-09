//}}}
//{{{ pageSetup() method
public static void pageSetup(View view) {
    PrinterJob prnJob = getPrintJob("PageSetupOnly");
    if (prnJob.pageDialog(format) != null)
        savePrintSpec();
}