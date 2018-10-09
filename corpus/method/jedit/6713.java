//{{{ DisplayManager constructor
private  DisplayManager(JEditBuffer buffer, TextArea textArea, DisplayManager copy) {
    this.buffer = buffer;
    this.screenLineMgr = new ScreenLineManager(buffer);
    this.textArea = textArea;
    scrollLineCount = new ScrollLineCount(this, textArea);
    firstLine = new FirstLine(this, textArea);
    bufferHandler = new BufferHandler(this, textArea, buffer);
    //TODO:invoke ElasticTabStopBufferListener methods from inside BufferHandler to avoid chunking same line twice
    elasticTabStopListener = new ElasticTabStopBufferListener(textArea);
    buffer.addBufferListener(elasticTabStopListener, JEditBuffer.HIGH_PRIORITY);
    // this listener priority thing is a bad hack...
    buffer.addBufferListener(bufferHandler, JEditBuffer.HIGH_PRIORITY);
    if (copy != null) {
        folds = new RangeMap(copy.folds);
        initialized = true;
    } else {
        folds = new RangeMap();
        folds.reset(0);
    }
}