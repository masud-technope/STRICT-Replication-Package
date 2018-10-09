//}}}
//{{{ showDockableWindow() method
/**
	 * Opens the specified dockable window.
	 * @param name The dockable window name
	 * @since jEdit 2.6pre3
	 */
public void showDockableWindow(String name) {
    lastEntry = windows.get(name);
    if (lastEntry == null) {
        Log.log(Log.ERROR, this, "Unknown dockable window: " + name);
        return;
    }
    if (lastEntry.win == null) {
        lastEntry.win = lastEntry.factory.createDockableWindow(view, lastEntry.position);
    }
    if (lastEntry.win != null) {
        if (lastEntry.position.equals(FLOATING) && lastEntry.container == null) {
            FloatingWindowContainer fwc = new FloatingWindowContainer(this, view.isPlainView());
            lastEntry.container = fwc;
            lastEntry.container.register(lastEntry);
        }
        showStack.push(name);
        lastEntry.container.show(lastEntry);
        Object reason = DockableWindowUpdate.ACTIVATED;
        EditBus.send(new DockableWindowUpdate(this, reason, name));
    } else
        /* an error occurred */
        ;
}