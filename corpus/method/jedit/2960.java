//}}}
//{{{ bufferSetSorted() method
/**
	 * The bufferSet was sorted
	 * @since jEdit 4.3pre16
	 */
public void bufferSetSorted() {
    if (bufferSwitcher != null)
        bufferSwitcher.updateBufferList();
}