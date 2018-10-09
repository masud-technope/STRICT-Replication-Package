// }}}
// {{{ addOptionGroup()
public void addOptionGroup(OptionGroup group) {
    OptionGroupPane pane = new OptionGroupPane(group);
    pane.addTextListener(new TitleChanger());
    addOptionPane(pane);
}