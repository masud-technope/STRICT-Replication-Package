public void mousePressed(MouseEvent evt) {
    if (evt.isConsumed())
        return;
    int index = markerList.locationToIndex(evt.getPoint());
    markerList.setSelectedIndex(index);
    goToSelectedMarker();
}