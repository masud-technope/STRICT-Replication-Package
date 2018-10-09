// {{{ TabbedOptionDialog constructor
public  TabbedOptionDialog(Frame frame, String name) {
    super(frame, jEdit.getProperty(name + ".title"), true);
    setName(name);
    setupTabs();
}