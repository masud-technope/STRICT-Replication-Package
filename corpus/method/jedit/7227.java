//}}}
//{{{ setOverwriteEnabled() method
/**
	 * Sets overwrite mode.
	 */
public final void setOverwriteEnabled(boolean overwrite) {
    blink = true;
    caretTimer.restart();
    this.overwrite = overwrite;
    invalidateLine(caretLine);
    fireStatusChanged(StatusListener.OVERWRITE_CHANGED, overwrite);
}