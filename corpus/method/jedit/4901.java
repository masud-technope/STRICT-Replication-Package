//}}}
//{{{ gotoMarker() method
private static void gotoMarker(final View view, final Buffer buffer, final String marker) {
    AwtRunnableQueue.INSTANCE.runAfterIoTasks(new Runnable() {

        @Override
        public void run() {
            int pos;
            // Handle line number
            if (marker.startsWith("+line:")) {
                try {
                    String arg = marker.substring(6);
                    String[] lineCol = arg.split(",");
                    int line, col;
                    if (lineCol.length > 1) {
                        line = Integer.parseInt(lineCol[0]);
                        col = Integer.parseInt(lineCol[1]);
                    } else {
                        line = Integer.parseInt(marker.substring(6));
                        col = 1;
                    }
                    pos = buffer.getLineStartOffset(line - 1) + (col - 1);
                } catch (Exception e) {
                    return;
                }
            } else // Handle marker
            if (marker.startsWith("+marker:")) {
                if (marker.length() != 9)
                    return;
                Marker m = buffer.getMarker(marker.charAt(8));
                if (m == null)
                    return;
                pos = m.getPosition();
            } else
                throw new InternalError();
            if (view != null && view.getBuffer() == buffer) {
                view.getTextArea().setCaretPosition(pos);
                buffer.setIntegerProperty(Buffer.CARET, pos);
                buffer.setBooleanProperty(Buffer.CARET_POSITIONED, true);
            } else {
                buffer.setIntegerProperty(Buffer.CARET, pos);
                buffer.setBooleanProperty(Buffer.CARET_POSITIONED, true);
                buffer.unsetProperty(Buffer.SCROLL_VERT);
            }
        }
    });
}