//}}}
//{{{ propertiesChanged() method
public void propertiesChanged() {
    renderer.propertiesChanged();
    VFSFile template = new VFSFile("foo", "foo", "foo", VFSFile.FILE, 0L, false);
    setRowHeight(renderer.getTableCellRendererComponent(this, new Entry(template, 0), false, false, 0, 0).getPreferredSize().height);
    Dimension prefSize = getPreferredSize();
    setPreferredScrollableViewportSize(new Dimension(prefSize.width, getRowHeight() * 12));
}