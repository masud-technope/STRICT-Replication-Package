public void printStackTrace(boolean debug, PrintStream out) {
    if (debug) {
        super.printStackTrace(out);
        out.println("--- Target Stack Trace ---");
    }
    target.printStackTrace(out);
}