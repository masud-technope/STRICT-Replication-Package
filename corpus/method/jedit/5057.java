//{{{ EnhancedMenu constructor
public  EnhancedMenu(String name) {
    this(name, jEdit.getProperty(name.concat(".label")), jEdit.getActionContext());
}