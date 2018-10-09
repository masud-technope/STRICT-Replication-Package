//}}}
//{{{ getFiles() method
public synchronized String[] getFiles(View view) {
    if (files == null)
        files = _getFiles(view);
    if (files == null || files.length == 0)
        return null;
    else
        return files;
}