//{{{ getFirstFile() method
public synchronized String getFirstFile(View view) {
    if (files == null)
        files = _getFiles(view);
    if (files == null || files.length == 0)
        return null;
    else
        return files[0];
}