public  PrintPreview(View view, Buffer buffer, PrintService printService, PrintRequestAttributeSet attributes) {
    super(view, jEdit.getProperty("printpreview.dialog.title"), true);
    this.view = view;
    this.buffer = buffer;
    this.printService = printService;
    this.attributes = attributes;
    installComponents();
    installListeners();
    init();
    pack();
    setLocationRelativeTo(jEdit.getActiveView().getTextArea());
    setVisible(true);
    // TODO: this repaint shouldn't be necessary, but sometimes the first
    // page isn't drawn when the preview is first displayed. This fixes that
    // problem, but this feels like the wrong way to do it.
    repaint();
}