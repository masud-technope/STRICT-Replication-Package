//}}}
//{{{ gotoURL() method
/**
	 * Displays the specified URL in the HTML component.
	 * 
	 * @param url 		 The URL
	 * @param addToHistory   Should the URL be added to the back/forward
	 * 			 history?
	 * @param scrollPosition The vertical scrollPosition
	 */
@Override
public void gotoURL(String url, final boolean addToHistory, final int scrollPosition) {
    // the TOC pane looks up user's guide URLs relative to the
    // doc directory...
    String shortURL;
    if (MiscUtilities.isURL(url)) {
        if (url.startsWith(baseURL)) {
            shortURL = url.substring(baseURL.length());
            if (shortURL.startsWith("/")) {
                shortURL = shortURL.substring(1);
            }
        } else {
            shortURL = url;
        }
    } else {
        shortURL = url;
        if (baseURL.endsWith("/")) {
            url = baseURL + url;
        } else {
            url = baseURL + '/' + url;
        }
    }
    // reset default cursor so that the hand cursor doesn't
    // stick around
    viewer.setCursor(Cursor.getDefaultCursor());
    try {
        final URL _url = new URL(url);
        final String _shortURL = shortURL;
        if (!_url.equals(viewer.getPage())) {
            title.setText(jEdit.getProperty("helpviewer.loading"));
        } else {
        /* don't show loading msg because we won't
				   receive a propertyChanged */
        }
        historyModel.setCurrentScrollPosition(viewer.getPage(), getCurrentScrollPosition());
        /* call setPage asynchronously, because it can block when
			   one can't connect to host.
			   Calling setPage outside from the EDT violates
			   the single-tread rule of Swing, but it's an experienced workaround
			   (see merge request #2984022 - fix blocking HelpViewer
			   https://sourceforge.net/tracker/?func=detail&aid=2984022&group_id=588&atid=1235750
			   for discussion).
			   Once jEdit sets JDK 7 as dependency, all this should be
			   reverted to synchronous code.
			 */
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

            private boolean success;

            @Override
            protected Void doInBackground() throws Exception {
                try {
                    // reset encoding
                    viewer.putClientProperty("charset", null);
                    // guess encoding
                    if (_url.getPath().matches(".+\\.([tT][xX][tT])")) {
                        URLConnection connection = _url.openConnection();
                        if (connection.getContentEncoding() == null) {
                            InputStream is = connection.getInputStream();
                            BufferedInputStream in = AutoDetection.getMarkedStream(is);
                            String encoding = ENCODING_DETECTOR.detectEncoding(in);
                            if (encoding != null) {
                                // JEditorPane uses charset to create the reader passed to the
                                // EditorKit in JEditorPane.read().
                                viewer.putClientProperty("charset", encoding);
                            }
                            in.close();
                        }
                    }
                    viewer.setPage(_url);
                    success = true;
                } catch (IOException io) {
                    Log.log(Log.ERROR, this, io);
                    String[] args = { _url.toString(), io.toString() };
                    GUIUtilities.error(HelpViewer.this, "read-error", args);
                }
                return null;
            }

            @Override
            protected void done() {
                if (success) {
                    if (scrollPosition != 0) {
                        viewerScrollPane.getVerticalScrollBar().setValue(scrollPosition);
                    }
                    if (addToHistory) {
                        historyModel.addToHistory(_url.toString());
                    }
                    HelpViewer.this.shortURL = _shortURL;
                    // select the appropriate tree node.
                    if (_shortURL != null) {
                        toc.selectNode(_shortURL);
                    }
                    viewer.requestFocus();
                }
            }
        };
        worker.execute();
    } catch (MalformedURLException mf) {
        Log.log(Log.ERROR, this, mf);
        String[] args = { url, mf.getMessage() };
        GUIUtilities.error(this, "badurl", args);
    }
}