//}}}
//{{{ getTransferData() method
public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
    if (jEditFileList.equals(flavor)) {
        return files;
    } else if (DataFlavor.stringFlavor.equals(flavor)) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < files.size(); i++) {
            VFSFile vfsFile = files.get(i);
            if (i != 0)
                builder.append('\n');
            builder.append(vfsFile.getPath());
        }
        return builder.toString();
    } else if (DataFlavor.javaFileListFlavor.equals(flavor)) {
        List<File> files = new ArrayList<File>(this.files.size());
        for (VFSFile file : this.files) {
            if (file.getVFS() instanceof FileVFS)
                files.add(new File(file.getPath()));
        }
        return files;
    }
    throw new UnsupportedFlavorException(flavor);
}