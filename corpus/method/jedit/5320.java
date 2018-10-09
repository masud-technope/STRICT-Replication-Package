//}}}
//{{{ _init() method
public void _init() {
    /* Default directory */
    String[] dirs = { jEdit.getProperty("options.browser.general.defaultPath.favorites"), jEdit.getProperty("options.browser.general.defaultPath.home"), jEdit.getProperty("options.browser.general.defaultPath.last"), jEdit.getProperty("options.browser.general.defaultPath.buffer"), jEdit.getProperty("options.browser.general.defaultPath.working") };
    defaultDirectory = new JComboBox<String>(dirs);
    String defaultDir = jEdit.getProperty("vfs.browser.defaultPath");
    if ("favorites".equals(defaultDir))
        defaultDirectory.setSelectedIndex(0);
    else if ("home".equals(defaultDir))
        defaultDirectory.setSelectedIndex(1);
    else if ("last".equals(defaultDir))
        defaultDirectory.setSelectedIndex(2);
    else if ("buffer".equals(defaultDir))
        defaultDirectory.setSelectedIndex(3);
    else if ("working".equals(defaultDir))
        defaultDirectory.setSelectedIndex(4);
    addComponent(jEdit.getProperty("options.browser.general.defaultPath"), defaultDirectory);
    /* Show tool bar */
    showToolbar = new JCheckBox(jEdit.getProperty("options.browser" + ".general.showToolbar"));
    showToolbar.setSelected(jEdit.getBooleanProperty("vfs.browser" + ".showToolbar"));
    addComponent(showToolbar);
    /* Show menu bar */
    showMenubar = new JCheckBox(jEdit.getProperty("options.browser" + ".general.showMenubar"));
    showMenubar.setSelected(jEdit.getBooleanProperty("vfs.browser" + ".showMenubar"));
    addComponent(showMenubar);
    /* Show icons */
    showIcons = new JCheckBox(jEdit.getProperty("options.browser" + ".general.showIcons"));
    showIcons.setSelected(jEdit.getBooleanProperty("vfs.browser" + ".showIcons"));
    addComponent(showIcons);
    /* Show hidden files */
    showHiddenFiles = new JCheckBox(jEdit.getProperty("options.browser" + ".general.showHiddenFiles"));
    showHiddenFiles.setSelected(jEdit.getBooleanProperty("vfs.browser" + ".showHiddenFiles"));
    addComponent(showHiddenFiles);
    /* Ignore case when sorting */
    sortIgnoreCase = new JCheckBox(jEdit.getProperty("options.browser" + ".general.sortIgnoreCase"));
    sortIgnoreCase.setSelected(jEdit.getBooleanProperty("vfs.browser" + ".sortIgnoreCase"));
    addComponent(sortIgnoreCase);
    /* Mix files and directories */
    sortMixFilesAndDirs = new JCheckBox(jEdit.getProperty("options.browser" + ".general.sortMixFilesAndDirs"));
    sortMixFilesAndDirs.setSelected(jEdit.getBooleanProperty("vfs.browser" + ".sortMixFilesAndDirs"));
    addComponent(sortMixFilesAndDirs);
    /* Double-click close */
    doubleClickClose = new JCheckBox(jEdit.getProperty("options.browser" + ".general.doubleClickClose"));
    doubleClickClose.setSelected(jEdit.getBooleanProperty("vfs.browser" + ".doubleClickClose"));
    addComponent(doubleClickClose);
    /* split VFSFileDialog horizontally */
    currentBufferFilter = new JCheckBox(jEdit.getProperty("options.browser" + ".general.currentBufferFilter"));
    currentBufferFilter.setSelected(jEdit.getBooleanProperty("vfs.browser" + ".currentBufferFilter"));
    addComponent(currentBufferFilter);
    /* use default icons. */
    useDefaultIcons = new JCheckBox(jEdit.getProperty("options.browser.general.useDefaultIcons"));
    useDefaultIcons.setSelected(jEdit.getBooleanProperty("vfs.browser.useDefaultIcons"));
    addComponent(useDefaultIcons);
}