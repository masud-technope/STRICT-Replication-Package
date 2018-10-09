//}}}
//{{{ reloadAllBuffers() method
/**
	 * Reloads all open buffers.
	 * @param view The view
	 * @param confirm If true, a confirmation dialog will be shown first
	 *	if any buffers are dirty
	 * @since jEdit 2.7pre2
	 */
public static void reloadAllBuffers(View view, boolean confirm) {
    boolean hasDirty = false;
    Buffer[] buffers = jEdit.getBuffers();
    for (int i = 0; i < buffers.length && !hasDirty; i++) hasDirty = !buffers[i].isUntitled() && buffers[i].isDirty();
    if (confirm && hasDirty) {
        int result = GUIUtilities.confirm(view, "reload-all", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result != JOptionPane.YES_OPTION)
            return;
    }
    // save caret info. Buffer.load() will load it.
    visit(new SaveCaretInfoVisitor());
    for (Buffer buffer : buffers) {
        if (buffer.isUntitled())
            continue;
        buffer.load(view, true);
    }
}