//}}}
//{{{ update() method
@Override
public void update(JMenu menu) {
    view = GUIUtilities.getView(menu);
    // auto detect
    JMenuItem auto = new JMenuItem(jEdit.getProperty("vfs.browser.commands.encoding.auto-detect"));
    auto.setActionCommand("auto-detect");
    auto.addActionListener(this);
    menu.add(auto);
    menu.addSeparator();
    // all the enabled encodings + the system encoding
    String[] encodings = MiscUtilities.getEncodings(true);
    String systemEncoding = System.getProperty("file.encoding");
    if (Arrays.binarySearch(encodings, systemEncoding) < 0) {
        String[] tmp_a = new String[encodings.length + 1];
        System.arraycopy(encodings, 0, tmp_a, 0, encodings.length);
        tmp_a[encodings.length] = systemEncoding;
        encodings = tmp_a;
    }
    Arrays.sort(encodings);
    int maxItems = jEdit.getIntegerProperty("menu.spillover", 20);
    for (int i = 0; i < encodings.length; i++) {
        JMenuItem mi = new JMenuItem(encodings[i]);
        mi.setActionCommand("encoding@" + encodings[i]);
        mi.addActionListener(this);
        if (menu.getMenuComponentCount() >= maxItems && i < encodings.length) {
            JMenu newMenu = new JMenu(jEdit.getProperty("common.more"));
            menu.add(newMenu);
            menu = newMenu;
        }
        menu.add(mi);
    }
    menu.addSeparator();
    // option to prompt for the encoding
    JMenuItem other = new JMenuItem(jEdit.getProperty("vfs.browser.other-encoding.label"));
    other.setActionCommand("other-encoding");
    other.addActionListener(this);
    menu.add(other);
}