public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
    if (text == null || text.length() == 0) {
        return;
    }
    String newString = new StringBuilder(getText()).replace(offset, offset + length, text).toString();
    if (!isInteger(newString)) {
        return;
    }
    setBackground(inRange(newString) ? defaultBackground : invalidStyle.getBackgroundColor());
    setForeground(inRange(newString) ? defaultForeground : invalidStyle.getForegroundColor());
    super.replace(fb, offset, length, text, attrs);
}