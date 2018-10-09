//{{{ setThrowable() method
private void setThrowable(Throwable throwable) {
    textArea.getBuffer().setReadOnly(false);
    if (throwable == null) {
        textArea.setText(null);
    } else {
        throwable.printStackTrace(printStream);
        textArea.setText(byteArrayOutputStream.toString());
        textArea.setCaretPosition(0);
        byteArrayOutputStream.reset();
    }
    textArea.getBuffer().setReadOnly(true);
//}}}
}