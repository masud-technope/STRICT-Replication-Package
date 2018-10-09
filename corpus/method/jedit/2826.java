//}}}
//{{{ readMarkers() method
private static void readMarkers(Buffer buffer, InputStream _in) throws IOException, InterruptedException {
    // For `reload' command
    buffer.removeAllMarkers();
    BufferedReader in = new BufferedReader(new InputStreamReader(_in));
    try {
        String line;
        while ((line = in.readLine()) != null) {
            if (Thread.interrupted())
                throw new InterruptedException();
            // malformed marks file?
            if (line.length() == 0)
                continue;
            // compatibility kludge for jEdit 3.1 and earlier
            if (line.charAt(0) != '!')
                continue;
            char shortcut = line.charAt(1);
            int start = line.indexOf(';');
            int end = line.indexOf(';', start + 1);
            int position = Integer.parseInt(line.substring(start + 1, end));
            buffer.addMarker(shortcut, position);
        }
        buffer.setMarkersChanged(false);
    } finally {
        in.close();
    }
}