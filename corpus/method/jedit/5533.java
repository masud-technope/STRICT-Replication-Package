 Button(String actionName, String iconName, Icon icon, String label) {
    this.actionName = actionName;
    this.iconName = iconName;
    this.icon = icon;
    this.label = GenericGUIUtilities.prettifyMenuLabel(label);
}