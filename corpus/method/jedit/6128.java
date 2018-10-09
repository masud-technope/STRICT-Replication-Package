//}}}
//{{{ getLastFile() method
public synchronized String getLastFile(View view) {
    if (files == null)
        files = _getFiles(view);
    if (files == null || files.length == 0)
        return null;
    else
        return files[files.length - 1];
}