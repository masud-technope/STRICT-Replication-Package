/**
		 * @return The short title, for the dockable button text
		 */
public String shortTitle() {
    String title = jEdit.getProperty(factory.name + ".title");
    if (title == null)
        return "NO TITLE PROPERTY: " + factory.name;
    else
        return title;
}