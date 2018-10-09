/**
	 * Returns true if the menu should be updated each time it is shown.
	 * Otherwise, it will only be updated when the menu is first created,
	 * and if the menu receives a {@link
	 * org.gjt.sp.jedit.msg.DynamicMenuChanged} message.
	 */
boolean updateEveryTime();