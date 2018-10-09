//}}}
//{{{ updateTitle() method
/**
	 * Updates the title bar.
	 */
public void updateTitle() {
    List<Buffer> buffers = new ArrayList<Buffer>();
    EditPane[] editPanes = getEditPanes();
    for (EditPane ep : editPanes) {
        Buffer buffer = ep.getBuffer();
        if (!buffers.contains(buffer))
            buffers.add(buffer);
    }
    StringBuilder title = new StringBuilder();
    /* On Mac OS X, apps are not supposed to show their name in the
		title bar. */
    if (!OperatingSystem.isMacOS()) {
        if (userTitle != null)
            title.append(userTitle);
        else
            title.append(jEdit.getProperty("view.title"));
    }
    for (int i = 0; i < buffers.size(); i++) {
        if (i != 0)
            title.append(", ");
        Buffer buffer = buffers.get(i);
        title.append(showFullPath && !buffer.isNewFile() ? buffer.getPath(true) : buffer.getName());
        if (buffer.isDirty())
            title.append(jEdit.getProperty("view.title.dirty"));
    }
    setTitle(title.toString());
}