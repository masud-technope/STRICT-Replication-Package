//}}}
//{{{ getFirstPhysicalLine() method
/**
	 * Returns the first visible physical line index.
	 * @since jEdit 4.0pre4
	 */
public final int getFirstPhysicalLine() {
    if (displayManager != null && displayManager.firstLine != null) {
        return displayManager.firstLine.getPhysicalLine();
    }
    return 0;
}