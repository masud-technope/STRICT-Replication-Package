// }}}
// {{{ _init() method
public void _init() {
    //String title = jEdit.getProperty("options.title");
    //setTitle(title);
    addOptionGroup(new GlobalOptionGroup());
    addOptionGroup(new PluginOptionGroup());
    // addOptionPane(new BufferOptionPane());
    setSelectedIndex(startingIndex);
    OptionGroupPane p = (OptionGroupPane) (tabs.getSelectedComponent());
    setTitle(p.getTitle());
    setVisible(true);
}