public void run() {
    // don't obscure existing message
    if (!currentMessageIsIO && message != null && !"".equals(message.getText().trim()))
        return;
    int requestCount = TaskManager.instance.countIoTasks();
    if (requestCount == 0) {
        setMessageAndClear(jEdit.getProperty("view.status.io.done"));
        currentMessageIsIO = true;
    } else if (requestCount == 1) {
        setMessage(jEdit.getProperty("view.status.io-1"));
        currentMessageIsIO = true;
    } else {
        Object[] args = { requestCount };
        setMessage(jEdit.getProperty("view.status.io", args));
        currentMessageIsIO = true;
    }
}