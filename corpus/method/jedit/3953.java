/**
	 * Setup the border (invisible initially)
	 */
public  RolloverButton() {
    //setContentAreaFilled(true);
    addMouseListener(new MouseOverHandler());
}