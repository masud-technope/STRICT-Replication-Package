//{{{ OptionsDialog constructor
protected  OptionsDialog(Dialog dialog, String name, String pane) {
    super(dialog, jEdit.getProperty(name + ".title"), true);
    init(name, pane);
}