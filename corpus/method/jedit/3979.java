//}}}
//{{{ doPaintContents() method
/**
	 *  Code common to the native and swing splash screens
	 */
private void doPaintContents(Graphics g, Dimension size) {
    g.setColor(Color.black);
    g.drawRect(0, 0, size.width - 1, size.height - 1);
    g.setColor(Color.white);
    g.fillRect(1, size.height - 1 - PROGRESS_HEIGHT, ((size.width - 2) * progress) / PROGRESS_COUNT, PROGRESS_HEIGHT);
    g.setColor(Color.black);
    if (label != null) {
        int drawOffsetX = (size.width - fm.stringWidth(label)) / 2;
        int drawOffsetY = size.height - 2 - PROGRESS_HEIGHT + (PROGRESS_HEIGHT + fm.getAscent() + fm.getDescent()) / 2;
        paintString(g, label, drawOffsetX, drawOffsetY);
    }
    String version = "version " + jEdit.getVersion();
    int drawOffsetX = (size.width / 2) - (fm.stringWidth(version) / 2);
    int drawOffsetY = size.height - PROGRESS_HEIGHT - fm.getDescent() - 3;
    paintString(g, version, drawOffsetX, drawOffsetY);
}