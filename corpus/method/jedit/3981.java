//}}}
//{{{ repaint() method
@Override
public void repaint() {
    if (realSplash == null) {
        // fallback to the default code
        super.repaint();
        return;
    }
    Graphics2D g = realSplash.createGraphics();
    if (g == null) {
        Log.log(Log.ERROR, SplashScreen.class, "using native splash screen, but can't obtain graphics from it");
        return;
    }
    Dimension size = realSplash.getSize();
    // tell the splash screen the zone to repaint (everything)
    g.setComposite(AlphaComposite.Clear);
    g.fillRect(0, 0, size.width, size.height);
    g.setPaintMode();
    doPaintContents(g, size);
    realSplash.update();
}