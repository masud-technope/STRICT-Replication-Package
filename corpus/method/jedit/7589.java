//}}}
//{{{ createPrintStream() method
private static PrintStream createPrintStream(final int urgency, final Object source) {
    return new LogPrintStream(urgency, source);
}