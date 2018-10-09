public void actionPerformed(ActionEvent evt) {
    String actionCommand = evt.getActionCommand();
    if (actionCommand.equals("auto-detect")) {
        browser.autoDetectEncoding = autoDetect.isSelected();
    } else if (actionCommand.equals("other-encoding")) {
        String encoding = GUIUtilities.input(browser, "encoding-prompt", null, jEdit.getProperty("buffer.encoding", System.getProperty("file.encoding")));
        if (encoding == null)
            return;
        browser.currentEncoding = encoding;
    } else if (actionCommand.startsWith("encoding@")) {
        browser.currentEncoding = actionCommand.substring(9);
    }
}