//}}}
//{{{ propertiesChanged() method
/**
	 * Called by jEdit when necessary. Plugins should not call this method.
	 */
public void propertiesChanged() {
    if (buffer == null)
        return;
    if (buffer.getBooleanProperty("elasticTabstops")) {
        //call this only if it was previously off
        if (!buffer.elasticTabstopsOn) {
            turnOnElasticTabstops();
        }
        if (buffer.getColumnBlock() != null) {
            buffer.getColumnBlock().setTabSizeDirtyStatus(true, true);
        }
    } else {
        buffer.elasticTabstopsOn = false;
    }
    int _tabSize = buffer.getTabSize();
    char[] foo = new char[_tabSize];
    for (int i = 0; i < foo.length; i++) foo[i] = ' ';
    tabSize = painter.getStringWidth(new String(foo));
    // Calculate an average to use a reasonable value for
    // propotional fonts.
    String charWidthSample = "mix";
    charWidthDouble = painter.getFont().getStringBounds(charWidthSample, painter.getFontRenderContext()).getWidth() / charWidthSample.length();
    charWidth = (int) Math.round(charWidthDouble);
    String oldWrap = wrap;
    wrap = buffer.getStringProperty("wrap");
    hardWrap = "hard".equals(wrap);
    String largeFileMode = buffer.getStringProperty("largefilemode");
    softWrap = "soft".equals(wrap) && !"limited".equals(largeFileMode) && !"nohighlight".equals(largeFileMode);
    boolean oldWrapToWidth = wrapToWidth;
    int oldWrapMargin = wrapMargin;
    setMaxLineLength(buffer.getIntegerProperty("maxLineLen", 0));
    boolean wrapSettingsChanged = !(wrap.equals(oldWrap) && oldWrapToWidth == wrapToWidth && oldWrapMargin == wrapMargin);
    if (displayManager != null && !bufferChanging && !buffer.isLoading() && wrapSettingsChanged) {
        displayManager.invalidateScreenLineCounts();
        displayManager.notifyScreenLineChanges();
    }
    chunkCache.reset();
    gutter.repaint();
    painter.repaint();
}