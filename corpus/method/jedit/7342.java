//}}}
//{{{ setBounds() method
/**
	 * It is a bad idea to override this, but we need to get the component
	 * event before the first repaint.
	 */
@Override
public void setBounds(int x, int y, int width, int height) {
    // everything gets reset every time, which leads to other problems.
    if (x == getX() && y == getY() && width == getWidth() && (height == getHeight() || height == getHeight() + 1)) {
        return;
    }
    super.setBounds(x, y, width, height);
    textArea.recalculateVisibleLines();
    if (!textArea.getBuffer().isLoading())
        textArea.recalculateLastPhysicalLine();
    textArea.propertiesChanged();
    textArea.updateMaxHorizontalScrollWidth();
    textArea.scrollBarsInitialized = true;
}