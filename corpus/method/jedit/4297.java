//{{{ componentMoved() method
@Override
public void componentMoved(ComponentEvent evt) {
    if (System.currentTimeMillis() - start < 1000L) {
        Rectangle r = win.getBounds();
        if (!windowOpened && r.equals(required))
            return;
        if (!r.equals(desired)) {
            Log.log(Log.DEBUG, GUIUtilities.class, "Window resize blocked: " + win.getBounds());
            win.setBounds(desired);
        }
    }
    win.removeComponentListener(this);
//}}}
}