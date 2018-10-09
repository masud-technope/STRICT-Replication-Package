//}}}
//{{{ composeBufferPropsFromHistory() method
/**
	 * Compose buffer-local properties which can be got from history.
	 * @since 4.3pre10
	 */
private static void composeBufferPropsFromHistory(Map<String, Object> props, String path) {
    BufferHistory.Entry entry = BufferHistory.getEntry(path);
    if (entry != null && saveCaret && props.get(Buffer.CARET) == null) {
        props.put(Buffer.CARET, entry.caret);
        if (entry.selection != null) {
            // getSelection() converts from string to
            // Selection[]
            props.put(Buffer.SELECTION, entry.getSelection());
        }
    }
    if (entry != null && props.get(JEditBuffer.ENCODING) == null) {
        if (entry.encoding != null)
            props.put(JEditBuffer.ENCODING, entry.encoding);
    }
    if (entry != null && props.get("mode") == null) {
        if (entry.mode != null)
            props.put("mode", entry.mode);
    }
}