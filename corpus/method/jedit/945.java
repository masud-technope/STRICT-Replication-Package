//{{{ VFSFileNameField constructor
public  VFSFileNameField(VFSBrowser browser, String model) {
    super(model);
    setEnterAddsToHistory(false);
    this.browser = browser;
    Dimension dim = getPreferredSize();
    dim.width = Integer.MAX_VALUE;
    setMaximumSize(dim);
    // Enable TAB pressed for completion instead of
    // focas traversal.
    final int FORWARD = KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS;
    HashSet<AWTKeyStroke> keys = new HashSet<AWTKeyStroke>(getFocusTraversalKeys(FORWARD));
    keys.remove(AWTKeyStroke.getAWTKeyStroke("pressed TAB"));
    setFocusTraversalKeys(FORWARD, keys);
}