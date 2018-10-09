public void bracketSelected(org.gjt.sp.jedit.textarea.TextArea textArea, int line, String text) {
    StatusBar status = view.getStatus();
    if (status == null)
        return;
    status.setMessageAndClear(jEdit.getProperty("view.status.bracket", new Object[] { line, text }));
}