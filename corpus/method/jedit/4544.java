//}}}
//{{{ _run() method
@Override
public void _run() {
    Log.log(Log.DEBUG, this, this + ".run()");
    if (source != null) {
        // single file copy
        try {
            VFS.copy(this, source, target, comp, false, false);
        } catch (IOException e) {
            Log.log(Log.ERROR, this, e, e);
        } finally {
            if (latch != null)
                latch.countDown();
        }
    } else {
        // List file copy
        copyFileList();
    }
}