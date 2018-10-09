//}}}
//{{{ update() method
public void update(JMenu menu) {
    // We build a set of lists, each list contains plugin menu
    // items that begin with a given letter.
    int count = 0;
    List<List<JMenuItem>> letters = new ArrayList<List<JMenuItem>>(26);
    for (int i = 0; i < 26; i++) {
        letters.add(new ArrayList<JMenuItem>());
    }
    PluginJAR[] pluginArray = jEdit.getPluginJARs();
    for (PluginJAR jar : pluginArray) {
        EditPlugin plugin = jar.getPlugin();
        if (plugin == null)
            continue;
        JMenuItem menuItem = plugin.createMenuItems();
        if (menuItem != null) {
            addToLetterMap(letters, menuItem);
            count++;
        }
    }
    if (count == 0) {
        JMenuItem menuItem = new JMenuItem(jEdit.getProperty("no-plugins.label"));
        menuItem.setEnabled(false);
        menu.add(menuItem);
        return;
    }
    // Sort each letter
    for (List<JMenuItem> letter1 : letters) Collections.sort(letter1, new MenuItemTextComparator());
    int maxItems = jEdit.getIntegerProperty("menu.spillover", 20);
    // if less than 20 items, put them directly in the menu
    if (count <= maxItems) {
        for (List<JMenuItem> items : letters) {
            for (JMenuItem item : items) menu.add(item);
        }
        return;
    }
    // Collect blocks of up to maxItems of consecutive letters
    count = 0;
    char first = 'A';
    JMenu submenu = new JMenu();
    menu.add(submenu);
    for (int i = 0; i < letters.size(); i++) {
        List<JMenuItem> letter = letters.get(i);
        if (count + letter.size() > maxItems && count != 0) {
            char last = (char) (i + 'A' - 1);
            if (last == first)
                submenu.setText(String.valueOf(first));
            else
                submenu.setText(first + " - " + last);
            first = (char) (i + 'A');
            count = 0;
            submenu = null;
        }
        for (JMenuItem item : letter) {
            if (submenu == null) {
                submenu = new JMenu();
                menu.add(submenu);
            }
            submenu.add(item);
        }
        count += letter.size();
    }
    if (submenu != null) {
        char last = 'Z';
        if (last == first)
            submenu.setText(String.valueOf(first));
        else
            submenu.setText(first + " - " + last);
    }
}