//{{{ DockablePanel constructor
 DockablePanel(PanelWindowContainer panel) {
    super(new CardLayout());
    this.panel = panel;
    this.wm = panel.getDockableWindowManager();
    ResizeMouseHandler resizeMouseHandler = new ResizeMouseHandler();
    addMouseListener(resizeMouseHandler);
    addMouseMotionListener(resizeMouseHandler);
}