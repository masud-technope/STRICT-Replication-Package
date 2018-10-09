//{{{ MenuButton constructor
 MenuButton() {
    setIcon(GUIUtilities.loadIcon(jEdit.getProperty("dropdown-arrow.icon")));
    setHorizontalTextPosition(SwingConstants.LEADING);
    //		setRequestFocusEnabled(false);
    setMargin(new Insets(1, 1, 1, 1));
    addMouseListener(new MouseHandler());
    addKeyListener(this);
    if (OperatingSystem.isMacOSLF())
        putClientProperty("JButton.buttonType", "toolbar");
    setAction(new Action());
//}}}
}