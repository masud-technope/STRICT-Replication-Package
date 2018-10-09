//{{{ getElementAt() method
public String getElementAt(int index) {
    if (wrap) {
        if (index < MAXLINES - logLineCount)
            return log[index + logLineCount];
        else
            return log[index - MAXLINES + logLineCount];
    } else
        return log[index];
//}}}
}