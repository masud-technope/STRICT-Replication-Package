//}}}
//{{{ goToParent() method
// TODO: remove this, it's never called
private void goToParent() {
    String name = MiscUtilities.getFileName(browser.getDirectory());
    String parent = MiscUtilities.getParentOfPath(browser.getDirectory());
    browser.setDirectory(parent);
    VFS vfs = VFSManager.getVFSForPath(parent);
    if ((vfs.getCapabilities() & VFS.LOW_LATENCY_CAP) != 0) {
        TaskManager.instance.waitForIoTasks();
        setText(name);
        browser.getBrowserView().getTable().doTypeSelect(name, browser.getMode() == VFSBrowser.CHOOSE_DIRECTORY_DIALOG);
    }
}