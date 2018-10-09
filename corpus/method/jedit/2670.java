//}}}
//{{{ clear() method
public void clear() {
    undosFirst = undosLast = redosFirst = null;
    undoCount = 0;
}