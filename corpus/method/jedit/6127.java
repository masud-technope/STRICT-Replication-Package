//}}}
//{{{ getNextFile() method
public synchronized String getNextFile(View view, String path) {
    return getPrevOrNextFile(view, path, Direction.NEXT);
}