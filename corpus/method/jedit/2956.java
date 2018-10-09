//{{{ EditPane constructor
 EditPane(@Nonnull View view, @Nullable BufferSet bufferSetSource, @Nonnull Buffer buffer) {
    super(new BorderLayout());
    BufferSet.Scope scope = jEdit.getBufferSetManager().getScope();
    BufferSet source = bufferSetSource;
    switch(scope) {
        case editpane:
            // do nothing
            break;
        case view:
            {
                EditPane editPane = view.getEditPane();
                if (editPane != null) {
                    // if we have an editpane we copy it
                    source = editPane.getBufferSet();
                }
            }
            break;
        case global:
            View activeView = jEdit.getActiveView();
            if (activeView != null) {
                EditPane editPane = activeView.getEditPane();
                if (editPane != null) {
                    source = editPane.getBufferSet();
                }
            }
            break;
    }
    bufferSet = new BufferSet(source);
    init = true;
    this.view = view;
    textArea = new JEditTextArea(view);
    bufferSet.addBufferSetListener(this);
    textArea.getPainter().setAntiAlias(new AntiAlias(jEdit.getProperty("view.antiAlias")));
    textArea.setMouseHandler(new MouseHandler(textArea));
    textArea.setTransferHandler(new TextAreaTransferHandler());
    markerHighlight = new MarkerHighlight();
    Gutter gutter = textArea.getGutter();
    gutter.setGutterEnabled(GutterOptionPane.isGutterEnabled());
    gutter.setMinLineNumberDigitCount(GutterOptionPane.getMinLineNumberDigits());
    gutter.setSelectionAreaEnabled(GutterOptionPane.isSelectionAreaEnabled());
    gutter.addExtension(markerHighlight);
    gutter.setSelectionPopupHandler(new GutterPopupHandler() {

        public void handlePopup(int x, int y, int line) {
            Buffer buffer = getBuffer();
            buffer.addOrRemoveMarker('\0', buffer.getLineStartOffset(line));
        }
    });
    textArea.addStatusListener(new StatusHandler());
    add(BorderLayout.CENTER, textArea);
    propertiesChanged();
    setBuffer(buffer);
    // view and global scope it is added through this list
    if (bufferSet.indexOf(buffer) == -1)
        bufferSet.addBuffer(buffer);
    loadBufferSwitcher();
    init = false;
    EditBus.addToBus(this);
}