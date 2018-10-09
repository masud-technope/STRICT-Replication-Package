//}}}
//{{{ getFileCount() method
public synchronized int getFileCount(View view) {
    if (files == null)
        files = _getFiles(view);
    if (files == null)
        return 0;
    else
        return files.length;
}