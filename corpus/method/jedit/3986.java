//{{{ SplashScreen constructor
public  SplashScreen() {
    realSplash = java.awt.SplashScreen.getSplashScreen();
    fm = getFontMetrics(labelFont);
    if (realSplash == null) {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        setBackground(Color.white);
        image = getToolkit().getImage(getClass().getResource("/org/gjt/sp/jedit/icons/splash.png"));
        MediaTracker tracker = new MediaTracker(this);
        tracker.addImage(image, 0);
        try {
            tracker.waitForAll();
        } catch (Exception e) {
            Log.log(Log.ERROR, this, e);
        }
        // sane default
        Dimension screen = getToolkit().getScreenSize();
        win = new JWindow();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        GraphicsDevice gd = gs[0];
        if (gd != null) {
            GraphicsConfiguration gconf = gd.getDefaultConfiguration();
            if (gconf != null) {
                Rectangle bounds = gconf.getBounds();
                screen = new Dimension(bounds.width, bounds.height);
            }
        }
        Dimension size = new Dimension(image.getWidth(this) + 2, image.getHeight(this) + 2);
        win.setSize(size);
        win.getContentPane().add(this, BorderLayout.CENTER);
        win.setLocation((screen.width - size.width) / 2, (screen.height - size.height) / 2);
        win.validate();
        win.setVisible(true);
    } else {
        win = null;
        image = null;
    }
}