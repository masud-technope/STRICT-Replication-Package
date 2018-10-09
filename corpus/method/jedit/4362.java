public void mouseReleased(MouseEvent evt) {
    int row = results.locationToIndex(evt.getPoint());
    if (row != -1) {
        Result result = (Result) results.getModel().getElementAt(row);
        helpViewer.gotoURL(result.file, true, 0);
    }
}