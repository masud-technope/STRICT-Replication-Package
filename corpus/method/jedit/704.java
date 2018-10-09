//}}}
//{{{ createEncodingMenu() method
private JMenu createEncodingMenu() {
    ActionHandler actionHandler = new ActionHandler();
    encodingMenuItems = new HashMap<String, JRadioButtonMenuItem>();
    JMenu encodingMenu = new JMenu(jEdit.getProperty("vfs.browser.commands.encoding.label"));
    JMenu menu = encodingMenu;
    autoDetect = new JCheckBoxMenuItem(jEdit.getProperty("vfs.browser.commands.encoding.auto-detect"));
    autoDetect.setSelected(browser.autoDetectEncoding);
    autoDetect.setActionCommand("auto-detect");
    autoDetect.addActionListener(actionHandler);
    menu.add(autoDetect);
    menu.addSeparator();
    ButtonGroup grp = new ButtonGroup();
    List<JMenuItem> encodingMenuItemList = new ArrayList<JMenuItem>();
    String[] encodings = MiscUtilities.getEncodings(true);
    for (String encoding : encodings) {
        JRadioButtonMenuItem mi = new JRadioButtonMenuItem(encoding);
        mi.setActionCommand("encoding@" + encoding);
        mi.addActionListener(actionHandler);
        grp.add(mi);
        encodingMenuItems.put(encoding, mi);
        encodingMenuItemList.add(mi);
    }
    String systemEncoding = System.getProperty("file.encoding");
    if (encodingMenuItems.get(systemEncoding) == null) {
        JRadioButtonMenuItem mi = new JRadioButtonMenuItem(systemEncoding);
        mi.setActionCommand("encoding@" + systemEncoding);
        mi.addActionListener(actionHandler);
        grp.add(mi);
        encodingMenuItems.put(systemEncoding, mi);
        encodingMenuItemList.add(mi);
    }
    Collections.sort(encodingMenuItemList, new MenuItemTextComparator());
    for (JMenuItem item : encodingMenuItemList) {
        JRadioButtonMenuItem mi = (JRadioButtonMenuItem) item;
        if (menu.getMenuComponentCount() > 20) {
            JMenu newMenu = new JMenu(jEdit.getProperty("common.more"));
            menu.add(newMenu);
            menu = newMenu;
        }
        menu.add(mi);
    }
    menu.addSeparator();
    otherEncoding = new JRadioButtonMenuItem();
    otherEncoding.setActionCommand("other-encoding");
    otherEncoding.addActionListener(actionHandler);
    grp.add(otherEncoding);
    menu.add(otherEncoding);
    return encodingMenu;
}