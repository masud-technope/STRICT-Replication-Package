//}}}
//{{{ copyFileList() method
private void copyFileList() {
    VFS vfs = VFSManager.getVFSForPath(target);
    Object targetSession = null;
    try {
        targetSession = vfs.createVFSSession(target, comp);
        if (targetSession == null) {
            Log.log(Log.ERROR, this, "Target VFS path cannot be reached");
            return;
        }
        VFSFile targetFile = vfs._getFile(targetSession, target, comp);
        if (targetFile == null) {
            Log.log(Log.ERROR, this, "Target is unreachable or do not exist");
            return;
        }
        if (targetFile.getType() != VFSFile.DIRECTORY) {
            Log.log(Log.ERROR, this, "Target is not a directory");
            return;
        }
        if (sources != null) {
            setMaximum(sources.size());
            for (int i = 0; i < sources.size(); i++) {
                setValue(i);
                String sourcePath = sources.get(i);
                String sourceName = MiscUtilities.getFileName(sourcePath);
                setLabel(sourceName);
                copy(targetSession, vfs, sourcePath, sourceName, target);
            }
        }
    } catch (IOException e) {
        Log.log(Log.ERROR, this, e);
    } catch (InterruptedException e) {
        Log.log(Log.WARNING, this, "Copy was interrupted");
    } finally {
        VFSManager.sendVFSUpdate(vfs, target, true);
        try {
            if (targetSession != null)
                vfs._endVFSSession(targetSession, comp);
        } catch (IOException e) {
        }
    }
}