//}}}
//{{{ getPrevFile() method
public synchronized String getPrevFile(View view, String path) {
    return getPrevOrNextFile(view, path, Direction.PREV);
}