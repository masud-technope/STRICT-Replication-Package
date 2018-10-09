@Override
public void mouseClicked(MouseEvent e) {
    super.mouseClicked(e);
    if (browserView.getBrowser().getMode() != VFSBrowser.BROWSER)
        return;
    int ind = getSelectionModel().getMinSelectionIndex();
    if (ind == -1)
        return;
    Entry node = (Entry) getModel().getValueAt(ind, 0);
    boolean isDir = node.dirEntry.getType() == VFSFile.DIRECTORY;
    EditBus.send(new VFSPathSelected(browserView.getBrowser().getView(), node.dirEntry.getPath(), isDir));
}