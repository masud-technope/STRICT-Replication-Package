//{{{ LogPrintStream constructor
 LogPrintStream(int urgency, Object source) {
    super(new LogOutputStream(urgency, source));
    buffer = new ByteArrayOutputStream();
    orig = out;
//}}}
}