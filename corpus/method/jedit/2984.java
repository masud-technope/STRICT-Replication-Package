public void narrowActive(org.gjt.sp.jedit.textarea.TextArea textArea) {
    StatusBar status = view.getStatus();
    if (status == null)
        return;
    status.setMessageAndClear(jEdit.getProperty("view.status.narrow"));
}