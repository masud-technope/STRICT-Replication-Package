//}}}
//{{{ run() method
public void _run() {
    /* if the VFS supports renaming files, we first
		 * save to #<filename>#save#, then rename that
		 * to <filename>, so that if the save fails,
		 * data will not be lost.
		 *
		 * as of 4.1pre7 we now call vfs.getTwoStageSaveName()
		 * instead of constructing the path directly
		 * since some VFS's might not allow # in filenames.
		 */
    boolean vfsRenameCap = (vfs.getCapabilities() & VFS.RENAME_CAP) != 0;
    boolean wantTwoStage = wantTwoStageSave(buffer);
    boolean twoStageSave = vfsRenameCap && wantTwoStage;
    try {
        String[] args = { vfs.getFileName(path) };
        setStatus(jEdit.getProperty("vfs.status.save", args));
        // the entire save operation can be aborted...
        setCancellable(true);
        String originalPath = path;
        path = vfs._canonPath(session, path, view);
        if (!MiscUtilities.isURL(path))
            path = MiscUtilities.resolveSymlinks(path);
        String savePath;
        if (twoStageSave) {
            savePath = vfs.getTwoStageSaveName(path);
            if (savePath == null) {
                throw new IOException("Can't get a temporary path for two-stage save: " + path);
            }
        } else {
            makeBackup();
            savePath = path;
        }
        OutputStream out = vfs._createOutputStream(session, savePath, view);
        if (out == null) {
            buffer.setBooleanProperty(ERROR_OCCURRED, true);
            return;
        }
        try {
            // this must be after the stream is created or
            // we deadlock with SSHTools.
            buffer.readLock();
            try {
                // complete
                if (path.endsWith(".gz"))
                    buffer.setBooleanProperty(Buffer.GZIPPED, true);
                else if (buffer.getName().endsWith(".gz")) {
                    // The path do not ends with gz.
                    // The buffer name was .gz.
                    // So it means it's blabla.txt.gz -> blabla.txt, I remove
                    // the gz property
                    buffer.setBooleanProperty(Buffer.GZIPPED, false);
                }
                if (buffer.getBooleanProperty(Buffer.GZIPPED))
                    out = new GZIPOutputStream(out);
                write(buffer, out);
            } finally {
                buffer.readUnlock();
            }
        } catch (InterruptedException e) {
            buffer.setBooleanProperty(ERROR_OCCURRED, true);
            Thread.currentThread().interrupt();
        } finally {
            IOUtilities.closeQuietly((Closeable) out);
        }
        if (twoStageSave) {
            makeBackup();
            if (!vfs._rename(session, savePath, path, view))
                throw new IOException("Rename failed: " + savePath);
        }
        if (!twoStageSave)
            // send the original path, let the receiver resolve symlinks if necessary
            VFSManager.sendVFSUpdate(vfs, originalPath, true);
    } catch (FileNotFoundException e) {
        Log.log(Log.ERROR, this, "Unable to save buffer " + e);
        String[] pp = { e.getMessage() };
        VFSManager.error(view, path, "ioerror.write-error", pp);
        buffer.setBooleanProperty(ERROR_OCCURRED, true);
    } catch (UnsupportedCharsetException e) {
        Log.log(Log.ERROR, this, e, e);
        String[] pp = { e.getCharsetName() };
        VFSManager.error(view, path, "ioerror.unsupported-encoding-error", pp);
        buffer.setBooleanProperty(ERROR_OCCURRED, true);
    } catch (Exception e) {
        Log.log(Log.ERROR, this, e);
        String[] pp = { e.toString() };
        VFSManager.error(view, path, "ioerror.write-error", pp);
        buffer.setBooleanProperty(ERROR_OCCURRED, true);
    } finally {
        try {
            vfs._saveComplete(session, buffer, path, view);
            if (twoStageSave) {
                vfs._finishTwoStageSave(session, buffer, path, view);
            }
            // clean up left-over markers file
            if (!jEdit.getBooleanProperty("persistentMarkers"))
                vfs._delete(session, Buffer.getMarkersPath(vfs, path), view);
            vfs._endVFSSession(session, view);
        } catch (Exception e) {
            Log.log(Log.ERROR, this, e);
            String[] pp = { e.toString() };
            VFSManager.error(view, path, "ioerror.write-error", pp);
            buffer.setBooleanProperty(ERROR_OCCURRED, true);
        }
    }
}