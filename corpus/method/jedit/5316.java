//{{{ BrowserColorsModel constructor
 BrowserColorsModel() {
    entries = new ArrayList<Entry>();
    int i = 0;
    String glob;
    while ((glob = jEdit.getProperty("vfs.browser.colors." + i + ".glob")) != null) {
        entries.add(new Entry(glob, jEdit.getColorProperty("vfs.browser.colors." + i + ".color", Color.black)));
        i++;
    }
}