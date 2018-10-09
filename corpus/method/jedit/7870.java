// {{{ TabbedOptionDialog constructor
public  TabbedOptionDialog(Dialog dialog, String name) {
    super(dialog, jEdit.getProperty(name + ".title"), true);
    setName(name);
    setupTabs();
}