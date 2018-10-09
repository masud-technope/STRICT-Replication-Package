//}}}
//{{{ setDirectory() method
public void setDirectory(String path) {
    if (path.startsWith("file:"))
        path = path.substring(5);
    path = MiscUtilities.expandVariables(path);
    pathField.setText(path);
    if (!startRequest())
        return;
    historyStack.push(path);
    browserView.saveExpansionState();
    Runnable delayedAWTRequest = new DelayedEndRequest();
    browserView.loadDirectory(null, path, true, delayedAWTRequest);
    this.path = path;
}