//}}}
//{{{ saveAllBuffers() method
/**
	 * Saves all open buffers.
	 * @param view The view
	 * @param confirm If true, a confirmation dialog will be shown first
	 * @since jEdit 2.7pre2
	 */
public static void saveAllBuffers(View view, boolean confirm) {
    List<Buffer> buffers = new ArrayList<Buffer>();
    List<String> selectedBuffers = new ArrayList<String>();
    {
        Buffer buffer = buffersFirst;
        while (buffer != null) {
            if (buffer.isDirty()) {
                buffers.add(buffer);
                selectedBuffers.add(buffer.getPath());
            }
            buffer = buffer.next;
        }
    }
    if (confirm && !buffers.isEmpty()) {
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        for (Buffer buffer : buffers) listModel.addElement(buffer.getPath());
        JList<String> bufferList = new JList<String>(listModel);
        bufferList.setVisibleRowCount(Math.min(listModel.getSize(), 10));
        bufferList.setSelectionInterval(0, listModel.getSize() - 1);
        int result = JOptionPane.showConfirmDialog(view, new Object[] { new JLabel(jEdit.getProperty("saveall.message")), new JScrollPane(bufferList) }, jEdit.getProperty("saveall.title"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result != JOptionPane.YES_OPTION)
            return;
        selectedBuffers = bufferList.getSelectedValuesList();
    }
    Buffer current = view.getBuffer();
    for (Buffer buffer : buffers) {
        if (selectedBuffers.contains(buffer.getPath())) {
            if (buffer.isNewFile())
                view.setBuffer(buffer);
            buffer.save(view, null, true, true);
        }
    }
    view.setBuffer(current);
}