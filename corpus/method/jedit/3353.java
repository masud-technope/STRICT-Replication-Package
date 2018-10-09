// }}}
// {{{ getDockingLayout()
@Override
public DockingLayout getDockingLayout(ViewConfig config) {
    DockableWindowConfig docking = new DockableWindowConfig();
    docking.top = getTopDockingArea().getCurrent();
    docking.left = getLeftDockingArea().getCurrent();
    docking.bottom = getBottomDockingArea().getCurrent();
    docking.right = getRightDockingArea().getCurrent();
    docking.topPos = getTopDockingArea().getDimension();
    docking.leftPos = getLeftDockingArea().getDimension();
    docking.bottomPos = getBottomDockingArea().getDimension();
    docking.rightPos = getRightDockingArea().getDimension();
    return docking;
}