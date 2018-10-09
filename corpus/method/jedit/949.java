//}}}
//{{{ doComplete() method
private void doComplete(String currentText) {
    int index = MiscUtilities.getLastSeparatorIndex(currentText);
    String dir;
    if (index != -1)
        dir = currentText.substring(0, index + 1);
    else
        dir = "";
    if (MiscUtilities.isAbsolutePath(currentText)) {
        if (dir.startsWith("/"))
            dir = dir.substring(1);
        dir = doComplete(VFSBrowser.getRootDirectory(), dir, false);
        if (dir == null)
            return;
        browser.setDirectory(dir);
        TaskManager.instance.waitForIoTasks();
        if (index == -1) {
            if (currentText.startsWith("/"))
                currentText = currentText.substring(1);
        } else
            currentText = currentText.substring(index + 1);
    } else {
        if (dir.length() != 0) {
            dir = doComplete(browser.getDirectory(), dir, false);
            if (dir == null)
                return;
            browser.setDirectory(dir);
            TaskManager.instance.waitForIoTasks();
            currentText = currentText.substring(index + 1);
        }
    }
    BrowserView view = browser.getBrowserView();
    view.selectNone();
    view.getTable().doTypeSelect(currentText, browser.getMode() == VFSBrowser.CHOOSE_DIRECTORY_DIALOG);
    String newText;
    VFSFile[] files = view.getSelectedFiles();
    if (files.length == 0)
        newText = currentText;
    else {
        String path = files[0].getPath();
        String name = files[0].getName();
        String parent = MiscUtilities.getParentOfPath(path);
        if (MiscUtilities.isAbsolutePath(currentText) && !currentText.startsWith(browser.getDirectory())) {
            newText = path;
        } else {
            if (MiscUtilities.pathsEqual(parent, browser.getDirectory()))
                newText = name;
            else
                newText = path;
        }
    }
    setText(newText);
}