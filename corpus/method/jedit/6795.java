//}}}
//{{{ getLineNumberDigitCount() method
private int getLineNumberDigitCount() {
    JEditBuffer buf = textArea.getBuffer();
    int minDigits = getMinLineNumberDigitCount();
    if (buf == null)
        return minDigits;
    int count = buf.getLineCount();
    int digits;
    for (digits = 0; count > 0; digits++) count /= 10;
    return (digits < minDigits) ? minDigits : digits;
}