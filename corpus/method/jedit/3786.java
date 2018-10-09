public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
    String newString = new StringBuilder(getText()).delete(offset, offset + length).toString();
    setBackground(inRange(newString) ? defaultBackground : invalidStyle.getBackgroundColor());
    setForeground(inRange(newString) ? defaultForeground : invalidStyle.getForegroundColor());
    super.remove(fb, offset, length);
}