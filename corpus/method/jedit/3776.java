//}}}
//{{{ refreshList() method
private void refreshList() {
    java.util.Vector<Marker> markers = view.getBuffer().getMarkers();
    if (markers.size() > 0) {
        markerListScroller.setViewportView(markerList);
        markerList.setListData(markers);
        markerList.setEnabled(true);
        next.setEnabled(true);
        previous.setEnabled(true);
        clear.setEnabled(true);
    } else {
        markerListScroller.setViewportView(new JLabel(jEdit.getProperty("no-markers.label")));
        next.setEnabled(false);
        previous.setEnabled(false);
        clear.setEnabled(false);
    }
}