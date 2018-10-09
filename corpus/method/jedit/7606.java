//{{{ getSize() method
public int getSize() {
    if (wrap)
        return MAXLINES;
    else
        return logLineCount;
//}}}
}