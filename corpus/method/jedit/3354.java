// }}}
// {{{ setDockingLayout()
public void setDockingLayout(DockingLayout docking) {
    DockableWindowConfig config = (DockableWindowConfig) docking;
    if (config == null)
        return;
    if (config.top != null && config.top.length() != 0)
        showDockableWindow(config.top);
    if (config.left != null && config.left.length() != 0)
        showDockableWindow(config.left);
    if (config.bottom != null && config.bottom.length() != 0)
        showDockableWindow(config.bottom);
    if (config.right != null && config.right.length() != 0)
        showDockableWindow(config.right);
}