//{{{ ColorWellButton constructor
public  ColorWellButton(Color color) {
    setIcon(new ColorWell(color));
    setMargin(new Insets(2, 2, 2, 2));
    addActionListener(new ActionHandler());
    // according to krisk this looks better on OS X...
    if (OperatingSystem.isMacOSLF())
        putClientProperty("JButton.buttonType", "toolbar");
}