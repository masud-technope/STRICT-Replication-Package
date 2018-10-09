//}}}
//{{{ directoryLoaded() method
/**
	 * Rebuild the parent view after a directory has been loaded.
	 *
	 * @param node
	 * @param path
	 * @param directory  
	 */
public void directoryLoaded(Object node, String path, java.util.List<VFSFile> directory) {
    //{{{ If reloading root, update parent directory list
    if (node == null) {
        DefaultListModel parentList = new DefaultListModel();
        String parent = path;
        for (; ; ) {
            VFS _vfs = VFSManager.getVFSForPath(parent);
            VFSFile file = null;
            if (_vfs instanceof FileVFS) {
                Object session = _vfs.createVFSSession(path, browser);
                try {
                    file = _vfs._getFile(session, parent, browser);
                    if (file != null) {
                        file.setName(_vfs.getFileName(parent));
                    }
                } catch (IOException e) {
                    Log.log(Log.ERROR, this, e, e);
                }
            }
            if (file == null) {
                // create a DirectoryEntry manually
                // instead of using _vfs._getFile()
                // since so many VFS's have broken
                // implementations of this method
                file = new VFSFile(_vfs.getFileName(parent), parent, parent, VFSFile.DIRECTORY, 0L, false);
            }
            /*parentList.insertElementAt(new VFSFile(
					_vfs.getFileName(parent),
					parent,parent,
					VFSFile.DIRECTORY,
					0L,false),0);*/
            parentList.insertElementAt(file, 0);
            String newParent = _vfs.getParentOfPath(parent);
            if (newParent == null || MiscUtilities.pathsEqual(parent, newParent))
                break;
            else
                parent = newParent;
        }
        parentDirectories.setModel(parentList);
        int index = parentList.getSize() - 1;
        parentDirectories.setSelectedIndex(index);
        parentDirectories.ensureIndexIsVisible(index);
    //}}}
    }
    table.setDirectory(VFSManager.getVFSForPath(path), node, directory, tmpExpanded);
}