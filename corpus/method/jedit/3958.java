/**
	 * Setup the border
	 */
public  RolloverToggleButton() {
    setBorderPainted(true);
    Color originalColor = UIManager.getColor("Button.darkShadow");
    Color rolloverColor = UIManager.getColor("Button.foreground");
    originalBorder = BorderFactory.createLineBorder(originalColor, 1);
    rolloverBorder = BorderFactory.createLineBorder(rolloverColor, 1);
    setBorder(originalBorder);
    setContentAreaFilled(false);
    addMouseListener(new MouseOverHandler());
}