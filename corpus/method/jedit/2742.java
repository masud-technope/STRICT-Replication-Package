//}}}
//{{{ finishSaving() method
private void finishSaving(View view, String oldPath, String oldSymlinkPath, String path, boolean rename, boolean error) {
    // But I don't think anyone calls it like that anyway.
    if (!error && !path.equals(oldPath)) {
        Buffer buffer = jEdit.getBuffer(path);
        if (rename) {
            /* if we save a file with the same name as one
				 * that's already open, we presume that we can
				 * close the existing file, since the user
				 * would have confirmed the overwrite in the
				 * 'save as' dialog box anyway */
            if (buffer != null && /* can't happen? */
            !buffer.getPath().equals(oldPath)) {
                buffer.setDirty(false);
                jEdit.closeBuffer(view, buffer);
            }
            setPath(path);
            jEdit.visit(new JEditVisitorAdapter() {

                @Override
                public void visit(EditPane editPane) {
                    BufferSet bufferSet = editPane.getBufferSet();
                    if (bufferSet.indexOf(Buffer.this) != -1) {
                        bufferSet.sort();
                    }
                }
            });
        } else {
            /* if we saved over an already open file using
				 * 'save a copy as', then reload the existing
				 * buffer */
            if (buffer != null && /* can't happen? */
            !buffer.getPath().equals(oldPath)) {
                buffer.load(view, true);
            }
        }
    //}}}
    }
    //{{{ Update this buffer for the new path
    if (rename) {
        if (file != null)
            modTime = file.lastModified();
        if (!error) {
            // and clearing of the dirty flag
            try {
                writeLock();
                if (autosaveFile != null)
                    autosaveFile.delete();
                setFlag(AUTOSAVE_DIRTY, false);
                setFileReadOnly(false);
                setFlag(NEW_FILE, false);
                setFlag(UNTITLED, false);
                super.setDirty(false);
                if (jEdit.getBooleanProperty("resetUndoOnSave")) {
                    undoMgr.clear();
                }
            } finally {
                writeUnlock();
            }
            parseBufferLocalProperties();
            if (!getPath().equals(oldPath)) {
                if (!isTemporary())
                    jEdit.updatePosition(oldSymlinkPath, this);
                setMode();
            } else {
                // if user adds mode buffer-local property
                String newMode = getStringProperty("mode");
                if (newMode != null && !newMode.equals(getMode().getName()))
                    setMode();
            }
            updateHash();
            if (!isTemporary()) {
                EditBus.send(new BufferUpdate(this, view, BufferUpdate.DIRTY_CHANGED));
                // new message type introduced in 4.0pre4
                EditBus.send(new BufferUpdate(this, view, BufferUpdate.SAVED));
            }
        }
    //}}}
    }
}