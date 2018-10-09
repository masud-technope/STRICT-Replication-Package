//}}}
//{{{ dispose() method
@Override
public void dispose() {
    GUIUtilities.saveGeometry(this, "vfs.browser.dialog");
    TaskManager.instance.removeTaskListener(ioTaskHandler);
    super.dispose();
}