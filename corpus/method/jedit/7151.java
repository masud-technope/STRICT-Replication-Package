//}}}
//{{{ selectNone() method
/**
	 * Deselects everything.
	 */
public void selectNone() {
    invalidateSelectedLines();
    setSelection((Selection) null);
}