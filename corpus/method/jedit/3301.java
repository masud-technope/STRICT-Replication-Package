//}}}
// {{{ toggleDockAreas()
/**
	 * Hides all visible dock areas, or shows them again,
	 * if the last time it was a hide.
	 * @since jEdit 4.3pre16
	 *
	 */
public void toggleDockAreas() {
    if (closeToggle) {
        tTop = getTopDockingArea().getCurrent() != null;
        tLeft = getLeftDockingArea().getCurrent() != null;
        tRight = getRightDockingArea().getCurrent() != null;
        tBottom = getBottomDockingArea().getCurrent() != null;
        getBottomDockingArea().show(null);
        getTopDockingArea().show(null);
        getRightDockingArea().show(null);
        getLeftDockingArea().show(null);
    } else {
        if (tBottom)
            getBottomDockingArea().showMostRecent();
        if (tLeft)
            getLeftDockingArea().showMostRecent();
        if (tRight)
            getRightDockingArea().showMostRecent();
        if (tTop)
            getTopDockingArea().showMostRecent();
    }
    view.closeAllMenus();
    closeToggle = !closeToggle;
    view.getTextArea().requestFocus();
}