 AboutPanel() {
    String mode;
    if (jEdit.getEditServer() != null) {
        if (jEdit.isBackgroundModeEnabled())
            mode = jEdit.getProperty("about.mode.server-background");
        else
            mode = jEdit.getProperty("about.mode.server");
    } else
        mode = jEdit.getProperty("about.mode.standalone");
    String[] args = { jEdit.getVersion(), mode, System.getProperty("java.vendor"), System.getProperty("java.version") };
    sBottomLine = jEdit.getProperty("about.version", args);
    setFont(defaultFont);
    fm = getFontMetrics(defaultFont);
    FontMetrics fmBottom = getFontMetrics(bottomLineFont);
    iLineHeight = fm.getHeight();
    image = (ImageIcon) GUIUtilities.loadIcon("about.png");
    MediaTracker tracker = new MediaTracker(this);
    tracker.addImage(image.getImage(), 0);
    try {
        tracker.waitForID(0);
    } catch (Exception exc) {
        tell("AboutPanel: " + exc);
    }
    Dimension d = new Dimension(image.getIconWidth(), image.getIconHeight());
    setSize(d);
    setPreferredSize(d);
    w = d.width;
    h = d.height;
    iBottomLineXOffset = (w / 2) - (fmBottom.stringWidth(sBottomLine) / 2);
    iBottomLineYOffset = h - fmBottom.getHeight() / 2;
    String aboutText = jEdit.getProperty("about.text.prefix") + "\n \n" + jEdit.getProperty("about.text.contributors") + "\n \n" + jEdit.getProperty("about.text.suffix");
    String[] contributors = aboutText.split("\n");
    vLines = Arrays.asList(contributors);
    iLineCount = vLines.size();
    iListHeight = iLineCount * iLineHeight;
    startThread();
    updateUI();
}