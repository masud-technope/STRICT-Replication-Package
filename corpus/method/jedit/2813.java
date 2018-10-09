//}}}
private void cleanUpIncomplete(OutputStream out) {
    // Incomplete autosave file should not exist.
    if (out != null) {
        try {
            out.close();
            out = null;
            vfs._delete(session, path, view);
        } catch (IOException ioe) {
            Log.log(Log.ERROR, this, ioe);
        }
    }
}