//{{{ UnixWorkaround constructor
public  UnixWorkaround(Window win, String name, Rectangle desired, int extState) {
    this.win = win;
    this.name = name;
    this.desired = desired;
    int adjust_x = jEdit.getIntegerProperty(name + ".dx", 0);
    int adjust_y = jEdit.getIntegerProperty(name + ".dy", 0);
    int adjust_width = jEdit.getIntegerProperty(name + ".d-width", 0);
    int adjust_height = jEdit.getIntegerProperty(name + ".d-height", 0);
    required = new Rectangle(desired.x - adjust_x, desired.y - adjust_y, desired.width - adjust_width, desired.height - adjust_height);
    Log.log(Log.DEBUG, GUIUtilities.class, "Window " + name + ": desired geometry is " + desired);
    Log.log(Log.DEBUG, GUIUtilities.class, "Window " + name + ": setting geometry to " + required);
    start = System.currentTimeMillis();
    win.setBounds(required);
    if (win instanceof Frame)
        ((Frame) win).setExtendedState(extState);
    win.addComponentListener(new ComponentHandler());
    win.addWindowListener(new WindowHandler());
//}}}
}