// }}}
// {{{ focusDockable
protected void focusDockable(String name) {
    JComponent c = getDockable(name);
    if (c == null)
        return;
    if (c instanceof DefaultFocusComponent)
        ((DefaultFocusComponent) c).focusOnDefaultComponent();
    else
        c.requestFocus();
}