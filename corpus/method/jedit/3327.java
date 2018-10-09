// }}}
// {{{ getDockablePosition()
protected String getDockablePosition(String name) {
    return jEdit.getProperty(name + ".dock-position", FLOATING);
}