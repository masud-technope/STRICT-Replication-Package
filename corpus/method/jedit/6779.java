//}}}
//{{{ getPreferredSize() method
/*
	 * Component.getPreferredSize() is overridden here to support the
	 * collapsing behavior.
	 */
public Dimension getPreferredSize() {
    if (!enabled)
        return disabledSize;
    if (expanded)
        return gutterSize;
    else
        return collapsedSize;
}