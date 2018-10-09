//}}}
//{{{ setFoldHandler() method
/**
	 * Sets the buffer's fold handler.
	 * @param foldHandler the fold handler
	 * @since jEdit 4.2pre2
	 */
public void setFoldHandler(@Nonnull FoldHandler foldHandler) {
    FoldHandler oldFoldHandler = this.foldHandler;
    if (foldHandler.equals(oldFoldHandler))
        return;
    this.foldHandler = foldHandler;
    lineMgr.setFirstInvalidFoldLevel(0);
    fireFoldHandlerChanged();
}