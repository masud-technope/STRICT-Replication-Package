public void addToClipboardAndHistory(String string) {
    setClipboard(string);
    HistoryModel.getModel("clipboard").addItem(string);
}