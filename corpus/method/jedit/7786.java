public char charAt(int i) {
    if (i >= buffer.getLength())
        return 0;
    return buffer.getText(i, 1).charAt(0);
}