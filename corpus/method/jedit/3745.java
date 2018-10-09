//}}}
//{{{ propertiesChanged() method
private void propertiesChanged() {
    cellRenderer.updateColors(list);
    list.setFont(jEdit.getFontProperty("view.font"));
    list.setFixedCellHeight(list.getFontMetrics(list.getFont()).getHeight());
}