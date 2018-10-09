/**
	 * Creates a new dynamic menu changed message.
	 * @param name The menu name. All dynamic menus with this name will be
	 * recreated next time they are displayed.
	 */
public  DynamicMenuChanged(String name) {
    super(null);
    this.name = name;
}