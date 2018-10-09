//}}}
//{{{ paste() method
/**
	 * Paste the file contained in the clipboard.
	 * If the clipboard do not contains files, nothing happens.
	 * @param file the target, it can be a file, in that case it will be pasted to
	 * the parent directory, or a directory.
	 */
@SuppressWarnings({ "unchecked" })
public void paste(VFSFile file) throws IOException, UnsupportedFlavorException {
    if (file == null)
        throw new IllegalArgumentException("file cannot be null");
    String targetPath = null;
    switch(file.getType()) {
        case VFSFile.FILESYSTEM:
            return;
        case VFSFile.FILE:
            targetPath = MiscUtilities.getParentOfPath(file.getPath());
            break;
        case VFSFile.DIRECTORY:
            targetPath = file.getPath();
            break;
        default:
            Log.log(Log.ERROR, this, "Unknown file type " + file.getType());
            return;
    }
    VFS vfs = VFSManager.getVFSForPath(targetPath);
    Object vfsSession = null;
    try {
        vfsSession = vfs.createVFSSession(targetPath, this);
        if (vfsSession == null) {
            Log.log(Log.ERROR, this, "Unable to create session for " + targetPath);
            return;
        }
        Transferable transferable = Registers.getRegister('$').getTransferable();
        List<String> sources = new ArrayList<String>();
        if (transferable.isDataFlavorSupported(ListVFSFileTransferable.jEditFileList)) {
            Iterable<VFSFile> copiedFiles = (Iterable<VFSFile>) transferable.getTransferData(ListVFSFileTransferable.jEditFileList);
            for (VFSFile copiedFile : copiedFiles) {
                sources.add(copiedFile.getPath());
            }
        } else if (transferable.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
            Iterable<File> copiedFiles = (Iterable<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);
            for (File copiedFile : copiedFiles) {
                sources.add(copiedFile.getAbsolutePath());
            }
        }
        CopyFileWorker worker = new CopyFileWorker(this, sources, targetPath, CopyFileWorker.Behavior.RENAME);
        ThreadUtilities.runInBackground(worker);
    } finally {
        if (vfsSession != null)
            vfs._endVFSSession(vfsSession, this);
    }
}