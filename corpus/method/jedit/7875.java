// }}}
// {{{ addOptionPane()
public void addOptionPane(OptionPane pane) {
    panes.add(pane);
    JPanel panel = (JPanel) pane;
    tabs.addTab(pane.getName(), panel);
}