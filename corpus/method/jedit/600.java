/**
	 * Creates a new option pane.
	 * @param internalName The internal name.
	 * This should be the same name as that provided
	 * in the plugin's <code>plugin.<i>className</i>.option-group</code>
	 * or <code>.option-pane</code> property.
	 *
	 * The option pane's label is set to the
	 * value of the property named <code>options.<i>name</i>.label</code>.
	 */
public  AbstractOptionPane(String internalName) {
    name = internalName;
    setLayout(gridBag = new GridBagLayout());
    setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
}