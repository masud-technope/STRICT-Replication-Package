//}}}
//{{{ getEntryWidth() method
int getEntryWidth(VFSDirectoryEntryTableModel.Entry entry, Font font, FontRenderContext fontRenderContext) {
    String name = entry.dirEntry.getName();
    int width = (int) font.getStringBounds(name, fontRenderContext).getWidth();
    width += ExpansionToggleBorder.ICON_WIDTH + entry.level * ExpansionToggleBorder.LEVEL_WIDTH + 3;
    if (showIcons) {
        width += fileIcon.getIconWidth();
        width += getIconTextGap();
    }
    return width;
}