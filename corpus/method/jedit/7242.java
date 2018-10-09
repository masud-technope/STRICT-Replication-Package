//}}}
//{{{ addNotify() method
/**
	 * Called by the AWT when this component is added to a parent.
	 * Adds document listener.
	 */
@Override
public void addNotify() {
    super.addNotify();
    ToolTipManager.sharedInstance().registerComponent(painter);
    ToolTipManager.sharedInstance().registerComponent(gutter);
    recalculateVisibleLines();
    if (!buffer.isLoading())
        recalculateLastPhysicalLine();
    propertiesChanged();
}