//}}}
public void adjust(View parent, ViewConfig config) {
    if (config.width != 0 && config.height != 0) {
        Rectangle desired = new Rectangle(config.x, config.y, config.width, config.height);
        if (!isInsideScreen(parent, desired))
            setLocationRelativeTo(parent);
        else {
            if (OperatingSystem.isX11() && Debug.GEOMETRY_WORKAROUND)
                new GUIUtilities.UnixWorkaround(this, "view", desired, config.extState);
            else {
                setBounds(desired);
                setExtendedState(config.extState);
            }
        }
    } else
        setLocationRelativeTo(parent);
}