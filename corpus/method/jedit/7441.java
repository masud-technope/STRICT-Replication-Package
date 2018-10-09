//}}}
//{{{ setUserTitle() method
/**
	 * Sets a user-defined title for this view instead of the "view.title" property.
	 */
public void setUserTitle(String title) {
    userTitle = title + " - ";
    updateTitle();
}