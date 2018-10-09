//}}}
//{{{ setMinLineNumberDigitCount() method
public void setMinLineNumberDigitCount(int min) {
    if (min == minLineNumberDigits)
        return;
    minLineNumberDigits = min;
    if (textArea.getBuffer() != null)
        updateLineNumberWidth();
}