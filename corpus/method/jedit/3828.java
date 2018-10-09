//}}}
//{{{ register() method
public void register(DockableWindowManagerImpl.Entry entry) {
    dockables.add(entry);
    //{{{ Create button
    int rotation;
    if (position.equals(DockableWindowManagerImpl.TOP) || position.equals(DockableWindowManagerImpl.BOTTOM))
        rotation = RotatedTextIcon.NONE;
    else if (position.equals(DockableWindowManagerImpl.LEFT))
        rotation = RotatedTextIcon.CCW;
    else if (position.equals(DockableWindowManagerImpl.RIGHT))
        rotation = RotatedTextIcon.CW;
    else
        throw new InternalError("Invalid position: " + position);
    JToggleButton button;
    if (jEdit.getBooleanProperty("use.rolloverToggleButtons")) {
        button = new RolloverToggleButton();
    } else {
        button = new JToggleButton();
        button.setMargin(new Insets(1, 1, 1, 1));
    }
    GenericGUIUtilities.setButtonContentMargin(button, new Insets(6, 6, 6, 6));
    button.setRequestFocusEnabled(false);
    button.setIcon(new RotatedTextIcon(rotation, button.getFont(), entry.shortTitle()));
    button.setActionCommand(entry.factory.name);
    button.addActionListener(new ActionHandler());
    button.addMouseListener(new MenuMouseHandler());
    if (OperatingSystem.isMacOSLF())
        button.putClientProperty("JButton.buttonType", "toolbar");
    //}}}
    buttonGroup.add(button);
    buttons.add(button);
    entry.btn = button;
    wm.revalidate();
}