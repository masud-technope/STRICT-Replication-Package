//{{{ BrowserCommandsMenu constructor
public  BrowserCommandsMenu(VFSBrowser browser, VFSFile[] files) {
    this.browser = browser;
    if (files != null) {
        VFS vfs = VFSManager.getVFSForPath(files[0].getDeletePath());
        int type = files[0].getType();
        boolean fileOpen = (jEdit.getBuffer(files[0].getPath()) != null);
        /* We check this flag separately so that we can
			delete open files from the favorites. */
        boolean deletePathOpen = (jEdit.getBuffer(files[0].getDeletePath()) != null);
        boolean delete = !deletePathOpen && (vfs.getCapabilities() & VFS.DELETE_CAP) != 0;
        boolean rename = !fileOpen && (vfs.getCapabilities() & VFS.RENAME_CAP) != 0;
        for (int i = 1; i < files.length; i++) {
            VFSFile file = files[i];
            VFS _vfs = VFSManager.getVFSForPath(file.getDeletePath());
            delete &= (vfs == _vfs) && (_vfs.getCapabilities() & VFS.DELETE_CAP) != 0;
            if (type == file.getType())
                /* all good */
                ;
            else {
                // this will disable most operations if
                // files of multiple types are selected
                type = -1;
            }
            // set rename to false if > 1 file selected
            rename = false;
            // file is currently open
            if (jEdit.getBuffer(file.getPath()) != null)
                fileOpen = true;
        }
        if (type == VFSFile.DIRECTORY || type == VFSFile.FILESYSTEM) {
            if (files.length == 1)
                add(createMenuItem("browse"));
            if (browser.getMode() == VFSBrowser.BROWSER)
                add(createMenuItem("browse-window"));
        } else if (type == VFSFile.FILE && (browser.getMode() == VFSBrowser.BROWSER || browser.getMode() == VFSBrowser.BROWSER_DIALOG)) {
            add(createMenuItem("open", "22x22/actions/document-open.png"));
            add(GUIUtilities.loadMenu(VFSBrowser.getActionContext(), "vfs.browser.open-in"));
            if (browser.getSelectedFiles().length == 1) {
                add(createMenuItem("open-desktop", "22x22/actions/document-open.png"));
                add(createMenuItem("insert"));
            }
            if (fileOpen)
                add(createMenuItem("close"));
        } else if (type != -1)
            add(createMenuItem("open", "22x22/actions/document-open.png"));
        if (rename)
            add(createMenuItem("rename"));
        if (delete)
            add(createMenuItem("delete", "22x22/actions/edit-delete.png"));
        add(createMenuItem("copy-path", "22x22/actions/edit-copy.png"));
        add(createMenuItem("paste", "22x22/actions/edit-paste.png"));
        if ((files.length == 1) || (browser.getSelectedFiles().length != 0))
            add(createMenuItem("properties", "22x22/actions/document-properties.png"));
        addSeparator();
    }
    add(createMenuItem("up", "22x22/actions/go-parent.png"));
    add(createMenuItem("previous", "22x22/actions/go-previous.png"));
    add(createMenuItem("next", "22x22/actions/go-next.png"));
    add(createMenuItem("reload", "22x22/actions/document-reload.png"));
    add(createMenuItem("roots"));
    add(createMenuItem("home", "22x22/actions/go-home.png"));
    add(createMenuItem("synchronize"));
    addSeparator();
    if (browser.getMode() == VFSBrowser.BROWSER)
        add(createMenuItem("new-file", "22x22/actions/document-new.png"));
    add(createMenuItem("new-directory", "22x22/actions/folder-new.png"));
    if (browser.getMode() == VFSBrowser.BROWSER) {
        addSeparator();
        add(createMenuItem("search-directory", "22x22/actions/system-search.png"));
    }
    addSeparator();
    add(createMenuItem("show-hidden-files"));
    if (browser.getMode() == VFSBrowser.BROWSER || browser.getMode() == VFSBrowser.BROWSER_DIALOG) {
        addSeparator();
        add(createEncodingMenu());
    }
    JMenu customMenu = createCustomMenu();
    if (customMenu != null) {
        addSeparator();
        Component[] menuComponents = customMenu.getMenuComponents();
        for (Component menuComponent : menuComponents) {
            add((JMenuItem) menuComponent);
        }
    }
    addSeparator();
    add(createPluginMenu(browser));
    update();
}