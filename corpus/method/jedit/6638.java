//}}}
//{{{ getFirstScreenLine() method
/**
	 * Find a valid line closest to the last screen line.
	 */
private int getFirstScreenLine() {
    for (int i = firstInvalidLine - 1; i >= 0; i--) {
        if (lineInfo[i].lastSubregion)
            return i + 1;
    }
    return 0;
}