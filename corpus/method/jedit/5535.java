//}}}
//{{{ reloadButtonList() method
private void reloadButtonList(String toolbar) {
    StringTokenizer st = new StringTokenizer(toolbar);
    listModel.clear();
    while (st.hasMoreTokens()) {
        String actionName = st.nextToken();
        if (actionName.equals("-"))
            listModel.addElement(new ToolBarOptionPane.Button("-", null, null, "-"));
        else {
            EditAction action = jEdit.getAction(actionName);
            if (action == null)
                continue;
            String label = action.getLabel();
            if (label == null)
                continue;
            Icon icon;
            String iconName;
            if (actionName.equals("-")) {
                iconName = null;
                icon = null;
            } else {
                iconName = jEdit.getProperty(actionName + ".icon");
                if (iconName == null)
                    icon = GUIUtilities.loadIcon(jEdit.getProperty("broken-image.icon"));
                else {
                    icon = GUIUtilities.loadIcon(iconName);
                    if (icon == null)
                        icon = GUIUtilities.loadIcon(jEdit.getProperty("broken-image.icon"));
                }
            }
            listModel.addElement(new Button(actionName, iconName, icon, label));
        }
    }
}