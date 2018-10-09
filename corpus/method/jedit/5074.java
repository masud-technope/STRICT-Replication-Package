//}}}
//{{{ update() method
public void update(JMenu menu) {
    final View view = GUIUtilities.getView(menu);
    Buffer buffer = view.getBuffer();
    List<Marker> markers = buffer.getMarkers();
    if (markers.isEmpty()) {
        JMenuItem mi = new JMenuItem(jEdit.getProperty("no-markers.label"));
        mi.setEnabled(false);
        menu.add(mi);
        return;
    }
    int maxItems = jEdit.getIntegerProperty("menu.spillover", 20);
    JMenu current = menu;
    for (int i = 0; i < markers.size(); i++) {
        final Marker marker = markers.get(i);
        int lineNo = buffer.getLineOfOffset(marker.getPosition());
        if (current.getItemCount() >= maxItems && i != markers.size() - 1) {
            //current.addSeparator();
            JMenu newCurrent = new JMenu(jEdit.getProperty("common.more"));
            current.add(newCurrent);
            current = newCurrent;
        }
        JMenuItem mi = new MarkersMenuItem(buffer, lineNo, marker.getShortcut());
        mi.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                view.getTextArea().setCaretPosition(marker.getPosition());
            }
        });
        current.add(mi);
    }
}