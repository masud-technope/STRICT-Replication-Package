//}}}
//{{{ print() method
public void print() {
    try {
        if (format == null)
            job.print();
        else {
            Method method = PrinterJob.class.getMethod("print", new Class[] { Class.forName("javax.print.attribute.PrintRequestAttributeSet") });
            method.invoke(job, new Object[] { format });
        }
    } catch (PrinterAbortException ae) {
        Log.log(Log.DEBUG, this, ae);
    } catch (Exception e) {
        Log.log(Log.ERROR, this, e);
        final String[] args = { e.toString() };
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                GUIUtilities.error(view, "print-error", args);
            }
        });
    }
}