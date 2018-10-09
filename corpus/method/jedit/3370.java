/**
		 * @return the long title for the dockable floating window.
		 */
public String longTitle() {
    String title = jEdit.getProperty(factory.name + ".longtitle");
    if (title == null)
        return shortTitle();
    else
        return title;
}