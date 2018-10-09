//}}}
//{{{ getSelectedFiles() method
public VFSFile[] getSelectedFiles() {
    VFSDirectoryEntryTableModel model = (VFSDirectoryEntryTableModel) getModel();
    java.util.List<VFSFile> returnValue = new LinkedList<VFSFile>();
    int[] selectedRows = getSelectedRows();
    for (int selectedRow : selectedRows) returnValue.add(model.files[selectedRow].dirEntry);
    return returnValue.toArray(new VFSFile[returnValue.size()]);
}