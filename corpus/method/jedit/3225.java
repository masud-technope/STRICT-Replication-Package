//}}}
//{{{ addLayoutComponent() method
public void addLayoutComponent(Component comp, Object cons) {
    if (cons == null || CENTER.equals(cons))
        center = comp;
    else if (DockableWindowManager.TOP.equals(cons))
        top = (DockablePanel) comp;
    else if (DockableWindowManager.LEFT.equals(cons))
        left = (DockablePanel) comp;
    else if (DockableWindowManager.BOTTOM.equals(cons))
        bottom = (DockablePanel) comp;
    else if (DockableWindowManager.RIGHT.equals(cons))
        right = (DockablePanel) comp;
    else if (TOP_BUTTONS.equals(cons))
        topButtons = comp;
    else if (LEFT_BUTTONS.equals(cons))
        leftButtons = comp;
    else if (BOTTOM_BUTTONS.equals(cons))
        bottomButtons = comp;
    else if (RIGHT_BUTTONS.equals(cons))
        rightButtons = comp;
}