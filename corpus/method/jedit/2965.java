//}}}
//{{{ getMinimumSize() method
/**
	 * Returns 0,0 for split pane compatibility.
	 */
@Override
public final Dimension getMinimumSize() {
    return new Dimension(0, 0);
}