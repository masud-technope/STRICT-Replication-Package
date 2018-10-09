//}}}
//{{{ endSessionQuietly() method
protected void endSessionQuietly() {
    try {
        vfs._endVFSSession(session, view);
    } catch (Exception e) {
        Log.log(Log.ERROR, this, e);
        String[] pp = { e.toString() };
        VFSManager.error(view, path, "ioerror.read-error", pp);
        buffer.setBooleanProperty(ERROR_OCCURRED, true);
    }
}