//}}}
//{{{ save() method
void save() {
    int i;
    for (i = 0; i < entries.size(); i++) {
        Entry entry = entries.get(i);
        jEdit.setProperty("vfs.browser.colors." + i + ".glob", entry.glob);
        jEdit.setColorProperty("vfs.browser.colors." + i + ".color", entry.color);
    }
    jEdit.unsetProperty("vfs.browser.colors." + i + ".glob");
    jEdit.unsetProperty("vfs.browser.colors." + i + ".color");
}