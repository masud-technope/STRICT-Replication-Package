//}}}
//{{{ removeNotify() method
/**
	 * Called by the AWT when this component is removed from it's parent.
	 * This clears the pointer to the currently focused component.
	 * Also removes document listener.
	 */
@Override
public void removeNotify() {
    super.removeNotify();
    ToolTipManager.sharedInstance().unregisterComponent(painter);
    ToolTipManager.sharedInstance().unregisterComponent(gutter);
    if (focusedComponent == this)
        focusedComponent = null;
    caretTimer.stop();
}