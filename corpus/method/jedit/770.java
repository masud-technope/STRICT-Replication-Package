//}}}
//{{{ dispose() method
/** Disposes the browser, regardless of whether it is a dialog or a dockable
	*/
public void dispose() {
    if (mode == BROWSER) {
        view.getDockableWindowManager().hideDockableWindow(NAME);
    } else {
        GenericGUIUtilities.getParentDialog(this).dispose();
    }
}