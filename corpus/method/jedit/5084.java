//}}}
//{{{ update() method
public void update(JMenu menu) {
    final View view = GUIUtilities.getView(menu);
    //{{{ ActionListener...
    ActionListener actionListener = new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
            jEdit.openFile(view, evt.getActionCommand());
            view.getStatus().setMessage(null);
        }
    };
    //{{{ ChangeListener...
    ChangeListener changeListener = new ChangeListener() {

        public void stateChanged(ChangeEvent e) {
            JMenuItem menuItem = (JMenuItem) e.getSource();
            view.getStatus().setMessage(menuItem.isArmed() ? menuItem.getActionCommand() : null);
        }
    };
    List<BufferHistory.Entry> recentVector = BufferHistory.getHistory();
    if (recentVector.isEmpty()) {
        JMenuItem menuItem = new JMenuItem(jEdit.getProperty("no-recent-files.label"));
        menuItem.setEnabled(false);
        menu.add(menuItem);
        return;
    }
    final List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
    final JTextField text = new JTextField();
    text.setToolTipText(jEdit.getProperty("recent-files.textfield.tooltip") + ": " + jEdit.getProperty("glob.tooltip"));
    menu.add(text);
    text.addKeyListener(new KeyAdapter() {

        public void keyReleased(KeyEvent e) {
            String typedText = text.getText();
            boolean filter = (typedText.length() > 0);
            Pattern pattern = null;
            if (filter) {
                String regex = typedText;
                if ((!typedText.contains("*")) && (!typedText.contains("?"))) {
                    // Old style (before jEdit 4.3pre18): Match start of file name
                    regex = regex + "*";
                }
                pattern = Pattern.compile(StandardUtilities.globToRE(regex), Pattern.CASE_INSENSITIVE);
            }
            try {
                for (JMenuItem recent : menuItems) {
                    recent.setEnabled(filter ? pattern.matcher(recent.getText()).matches() : true);
                }
            } catch (PatternSyntaxException re) {
                Log.log(Log.ERROR, this, re.getMessage());
            }
        }
    });
    boolean sort = jEdit.getBooleanProperty("sortRecent");
    int maxItems = jEdit.getIntegerProperty("menu.spillover", 20);
    Iterator<BufferHistory.Entry> iter = recentVector.iterator();
    while (iter.hasNext()) {
        String path = iter.next().path;
        if (jEdit.getBooleanProperty("hideOpen") && jEdit.getBuffer(path) != null)
            continue;
        JMenuItem menuItem = new JMenuItem(MiscUtilities.getFileName(path));
        menuItem.setToolTipText(path);
        menuItem.setActionCommand(path);
        menuItem.addActionListener(actionListener);
        //			menuItem.addMouseListener(mouseListener);
        menuItem.addChangeListener(changeListener);
        menuItem.setIcon(FileCellRenderer.fileIcon);
        menuItems.add(menuItem);
        if (!sort) {
            if (menu.getMenuComponentCount() >= maxItems && iter.hasNext()) {
                JMenu newMenu = new JMenu(jEdit.getProperty("common.more"));
                menu.add(newMenu);
                menu = newMenu;
            }
            menu.add(menuItem);
        }
    }
    if (sort) {
        Collections.sort(menuItems, new MenuItemTextComparator());
        for (int i = 0; i < menuItems.size(); i++) {
            if (menu.getMenuComponentCount() >= maxItems && i != 0) {
                JMenu newMenu = new JMenu(jEdit.getProperty("common.more"));
                menu.add(newMenu);
                menu = newMenu;
            }
            menu.add(menuItems.get(i));
        }
    }
    JMenuItem menuItem = new JMenuItem(jEdit.getProperty("clear-recent-files.label"));
    menuItem.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            BufferHistory.clear();
        }
    });
    menu.addSeparator();
    menu.add(menuItem);
}