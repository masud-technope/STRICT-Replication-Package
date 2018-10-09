//{{{ EnhancedMenu constructor
public  EnhancedMenu(String name, String label, ActionContext context) {
    this.context = context;
    if (label == null)
        label = name;
    char mnemonic;
    int index = label.indexOf('$');
    if (index != -1 && label.length() - index > 1) {
        mnemonic = Character.toLowerCase(label.charAt(index + 1));
        label = label.substring(0, index).concat(label.substring(++index));
    } else
        mnemonic = '\0';
    setText(label);
    if (!OperatingSystem.isMacOS())
        setMnemonic(mnemonic);
    String menuItems = jEdit.getProperty(name);
    if (menuItems != null) {
        StringTokenizer st = new StringTokenizer(menuItems);
        while (st.hasMoreTokens()) {
            String menuItemName = st.nextToken();
            if (menuItemName.equals("-"))
                addSeparator();
            else
                add(GUIUtilities.loadMenuItem(context, menuItemName, true));
        }
    }
    initialComponentCount = getMenuComponentCount();
    providerCode = jEdit.getProperty(name + ".code");
    ebStub = new EditBusStub(name);
    ebStub.menuOutOfDate = true;
    addMenuListener(this);
    if (providerCode != null)
        EditBus.addToBus(ebStub);
}