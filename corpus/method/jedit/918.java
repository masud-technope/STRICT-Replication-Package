//}}}
//{{{ setRoot() method
public void setRoot(VFS vfs, List<VFSFile> list) {
    extAttrs.clear();
    addExtendedAttributes(vfs);
    /* if(files != null && files.length != 0)
			fireTableRowsDeleted(0,files.length - 1); */
    files = new Entry[list.size()];
    for (int i = 0; i < files.length; i++) {
        files[i] = new Entry(list.get(i), 0);
    }
    /* if(files.length != 0)
			fireTableRowsInserted(0,files.length - 1); */
    Arrays.sort(files, new EntryCompare(getSortAttribute(sortColumnIndex), ascending));
    fireTableStructureChanged();
}