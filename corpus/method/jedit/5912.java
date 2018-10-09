@Override
public void printJobFailed(PrintJobEvent pje) {
    JOptionPane.showMessageDialog(view, jEdit.getProperty("print-error.message", new String[] { "Print job failed." }), jEdit.getProperty("print-error.title"), JOptionPane.ERROR_MESSAGE);
}