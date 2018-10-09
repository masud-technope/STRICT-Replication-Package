//}}}
//{{{ closeCurrentArea() method
/**
	 * Closes the most recently focused dockable.
	 * @since jEdit 4.1pre3
	 */
public void closeCurrentArea() {
    // I don't know of any other way to fix this, since invoking this
    // command from a menu results in the focus owner being the menu
    // until the menu goes away.
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            /* Try to hide the last entry that was shown */
            try {
                String dockableName = showStack.pop();
                hideDockableWindow(dockableName);
                return;
            } catch (Exception e) {
            }
            Component comp = view.getFocusOwner();
            while (comp != null) {
                //System.err.println(comp.getClass());
                if (comp instanceof DockablePanel) {
                    DockablePanel panel = (DockablePanel) comp;
                    PanelWindowContainer container = panel.getWindowContainer();
                    container.show((DockableWindowManagerImpl.Entry) null);
                    return;
                }
                comp = comp.getParent();
            }
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        }
    });
}