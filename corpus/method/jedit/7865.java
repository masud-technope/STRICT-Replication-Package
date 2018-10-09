// {{{ stateChanged()
public void stateChanged(ChangeEvent e) {
    OptionPane op = (OptionPane) tabs.getSelectedComponent();
    shownPanes.add(op);
    jEdit.setIntegerProperty("optional.last.tab", tabs.getSelectedIndex());
    setTitle(op.getName());
}