//}}}
//{{{ getValueAt() method
public Object getValueAt(int row, int col) {
    if (files == null)
        return null;
    else
        return files[row];
}