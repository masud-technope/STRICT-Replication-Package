@Override
protected void handleException(View view, String path, Throwable t) {
    if (t instanceof IOException) {
        VFSManager.error(view, path, "ioerror.read-error", new String[] { t.toString() });
    } else
        new BeanShellErrorDialog(view, t);
}