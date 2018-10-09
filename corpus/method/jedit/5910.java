@Override
public void printJobRequiresAttention(PrintJobEvent pje) {
    JOptionPane.showMessageDialog(view, jEdit.getProperty("print-error.message", new String[] { "Check the printer." }), jEdit.getProperty("print-error.title"), JOptionPane.ERROR_MESSAGE);
}