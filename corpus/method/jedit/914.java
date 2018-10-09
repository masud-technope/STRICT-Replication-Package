//}}}
//{{{ getRowCount() method
public int getRowCount() {
    if (files == null)
        return 0;
    else
        return files.length;
}