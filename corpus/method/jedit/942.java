// }}}
//{{{ _init method
private void _init(View view, String path, int mode, boolean multipleSelection, boolean autoshow) {
    JPanel content = new JPanel(new BorderLayout());
    setContentPane(content);
    String name;
    if (mode == VFSBrowser.CHOOSE_DIRECTORY_DIALOG)
        name = null;
    else if (path == null || path.endsWith(File.separator) || path.endsWith("/")) {
        name = null;
    } else {
        VFS vfs = VFSManager.getVFSForPath(path);
        name = vfs.getFileName(path);
        path = vfs.getParentOfPath(path);
        if ((vfs.getCapabilities() & VFS.BROWSE_CAP) == 0) {
            path = null;
        }
    }
    browser = new VFSBrowser(view, path, mode, multipleSelection, null);
    browser.addBrowserListener(new BrowserHandler());
    content.add(BorderLayout.CENTER, browser);
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
    panel.setBorder(new EmptyBorder(12, 12, 12, 12));
    filenameField = new VFSFileNameField(browser, null);
    filenameField.setText(name);
    filenameField.selectAll();
    filenameField.setName("filename");
    browser.setDefaultFocusComponent(filenameField);
    Box box = new Box(BoxLayout.Y_AXIS);
    box.add(Box.createGlue());
    box.add(filenameField);
    box.add(Box.createGlue());
    JLabel label = new JLabel(jEdit.getProperty("vfs.browser.dialog.filename"));
    label.setDisplayedMnemonic(jEdit.getProperty("vfs.browser.dialog.filename.mnemonic").charAt(0));
    label.setLabelFor(filenameField);
    panel.add(label);
    panel.add(Box.createHorizontalStrut(12));
    panel.add(box);
    panel.add(Box.createHorizontalStrut(12));
    ok = new JButton();
    ok.setName("ok");
    getRootPane().setDefaultButton(ok);
    switch(mode) {
        case VFSBrowser.OPEN_DIALOG:
        case VFSBrowser.BROWSER_DIALOG:
            ok.setText(jEdit.getProperty("vfs.browser.dialog.open"));
            break;
        case VFSBrowser.CHOOSE_DIRECTORY_DIALOG:
            ok.setText(jEdit.getProperty("vfs.browser.dialog.choose-dir"));
            // so that it doesn't resize...
            Dimension dim = ok.getPreferredSize();
            ok.setPreferredSize(dim);
            break;
        case VFSBrowser.SAVE_DIALOG:
            ok.setText(jEdit.getProperty("vfs.browser.dialog.save"));
            break;
    }
    ok.addActionListener(new ActionHandler());
    cancel = new JButton(jEdit.getProperty("common.cancel"));
    cancel.setName("cancel");
    cancel.addActionListener(new ActionHandler());
    GenericGUIUtilities.makeSameSize(ok, cancel);
    panel.add(Box.createHorizontalStrut(6));
    panel.add(ok);
    panel.add(Box.createHorizontalStrut(6));
    panel.add(cancel);
    content.add(BorderLayout.SOUTH, panel);
    TaskManager.instance.addTaskListener(ioTaskHandler = new IoTaskHandler());
    pack();
    GUIUtilities.loadGeometry(this, "vfs.browser.dialog");
    GenericGUIUtilities.requestFocus(this, filenameField);
    if (autoshow)
        setVisible(true);
}