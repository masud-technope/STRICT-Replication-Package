public void updateColors(JList list) {
    this.list = list;
    debugColor = jEdit.getColorProperty("log-viewer.message.debug.color", Color.BLUE);
    messageColor = jEdit.getColorProperty("log-viewer.message.message.color", Color.BLACK);
    noticeColor = jEdit.getColorProperty("log-viewer.message.notice.color", Color.GREEN);
    warningColor = jEdit.getColorProperty("log-viewer.message.warning.color", Color.ORANGE);
    errorColor = jEdit.getColorProperty("log-viewer.message.error.color", Color.RED);
    setFont(list.getFont());
    FontMetrics fm = list.getFontMetrics(list.getFont());
    baseline = fm.getAscent() + borderWidth;
    this.width = list.getWidth();
    this.height = fm.getHeight() + (2 * borderWidth);
}