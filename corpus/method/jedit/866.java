//}}}
//{{{ getExpandedDirectories() method
public void getExpandedDirectories(Set<String> set) {
    VFSDirectoryEntryTableModel model = (VFSDirectoryEntryTableModel) getModel();
    if (model.files != null) {
        for (int i = 0; i < model.files.length; i++) {
            if (model.files[i].expanded)
                set.add(model.files[i].dirEntry.getPath());
        }
    }
}