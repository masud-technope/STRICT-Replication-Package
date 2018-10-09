//}}}
//{{{ writeMarkers() method
private void writeMarkers(OutputStream out) throws IOException {
    Writer o = new BufferedWriter(new OutputStreamWriter(out));
    try {
        List<Marker> markers = buffer.getMarkers();
        synchronized (markers) {
            setMaximum(markers.size());
            for (int i = 0; i < markers.size(); i++) {
                setValue(i + 1);
                Marker marker = markers.get(i);
                o.write('!');
                o.write(marker.getShortcut());
                o.write(';');
                String pos = String.valueOf(marker.getPosition());
                o.write(pos);
                o.write(';');
                o.write(pos);
                o.write('\n');
            }
        }
    } finally {
        o.close();
    }
}