//{{{ hyperlinkUpdate() method
@Override
public void hyperlinkUpdate(HyperlinkEvent evt) {
    if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
        if (evt instanceof HTMLFrameHyperlinkEvent) {
            ((HTMLDocument) viewer.getDocument()).processHTMLFrameHyperlinkEvent((HTMLFrameHyperlinkEvent) evt);
            historyUpdated();
        } else {
            URL url = evt.getURL();
            if (url != null) {
                gotoURL(url.toString(), true, 0);
            }
        }
    } else if (evt.getEventType() == HyperlinkEvent.EventType.ENTERED) {
        viewer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    } else if (evt.getEventType() == HyperlinkEvent.EventType.EXITED) {
        viewer.setCursor(Cursor.getDefaultCursor());
    }
//}}}
}