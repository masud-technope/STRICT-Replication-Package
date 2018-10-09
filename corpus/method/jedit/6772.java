//{{{ Gutter constructor
public  Gutter(TextArea textArea) {
    this.textArea = textArea;
    enabled = true;
    selectionAreaEnabled = true;
    selectionAreaWidth = SELECTION_GUTTER_WIDTH;
    setAutoscrolls(true);
    setOpaque(true);
    setRequestFocusEnabled(false);
    extensionMgr = new ExtensionManager();
    mouseHandler = new MouseHandler();
    addMouseListener(mouseHandler);
    addMouseMotionListener(mouseHandler);
    bufferListener = new BufferAdapter() {

        public void bufferLoaded(JEditBuffer buffer) {
            updateLineNumberWidth();
        }

        public void contentInserted(JEditBuffer buffer, int startLine, int offset, int numLines, int length) {
            if (numLines != 0)
                updateLineNumberWidth();
        }

        public void contentRemoved(JEditBuffer buffer, int startLine, int offset, int numLines, int length) {
            if (numLines != 0)
                updateLineNumberWidth();
        }
    };
    updateBorder();
    setFoldPainter(textArea.getFoldPainter());
}