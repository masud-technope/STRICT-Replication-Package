public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
    if (string == null || string.length() == 0) {
        return;
    }
    String newString = new StringBuilder(getText()).insert(offset, string).toString();
    if (!isInteger(newString)) {
        return;
    }
    setBackground(inRange(newString) ? defaultBackground : invalidStyle.getBackgroundColor());
    setForeground(inRange(newString) ? defaultForeground : invalidStyle.getForegroundColor());
    super.insertString(fb, offset, string, attr);
}