//}}}
//{{{ setDockableTitle() method
/**
	 * Changes the .longtitle property of a dockable window, which corresponds to the
	 * title shown when it is floating (not docked). Fires a change event that makes sure
	 * all floating dockables change their title.
	 *
	 * @param dockable the name of the dockable, as specified in the dockables.xml
	 * @param title the new .longtitle you want to see above it.
	 * @since 4.3pre5
	 *
	 */
public void setDockableTitle(String dockable, String title) {
    String propName = getLongTitlePropertyName(dockable);
    String oldTitle = jEdit.getProperty(propName);
    jEdit.setProperty(propName, title);
    firePropertyChange(propName, oldTitle, title);
    dockableTitleChanged(dockable, title);
}