//}}}
//{{{ hasNext() method
public boolean hasNext() {
    return !((history.length - historyPos <= 1) || (history[historyPos] == null));
}