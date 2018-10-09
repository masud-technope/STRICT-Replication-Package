//{{{ windowOpened() method
@Override
public void windowOpened(WindowEvent evt) {
    windowOpened = true;
    Rectangle r = win.getBounds();
    Log.log(Log.DEBUG, GUIUtilities.class, "Window " + name + ": bounds after opening: " + r);
    jEdit.setIntegerProperty(name + ".dx", r.x - required.x);
    jEdit.setIntegerProperty(name + ".dy", r.y - required.y);
    jEdit.setIntegerProperty(name + ".d-width", r.width - required.width);
    jEdit.setIntegerProperty(name + ".d-height", r.height - required.height);
    win.removeWindowListener(this);
//}}}
}