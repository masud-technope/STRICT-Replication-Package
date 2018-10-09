//}}}
//{{{ getSelectedFiles() method
private String[] getSelectedFiles(int type1, int type2) {
    List<String> l = new ArrayList<String>();
    VFSFile[] selectedFiles = browser.getSelectedFiles();
    for (VFSFile file : selectedFiles) {
        if (file.getType() == type1 || file.getType() == type2)
            l.add(file.getPath());
    }
    return l.toArray(new String[l.size()]);
}