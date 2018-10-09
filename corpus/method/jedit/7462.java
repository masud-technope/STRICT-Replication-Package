//}}}
//{{{ restoreSplitConfig() method
private Component restoreSplitConfig(Buffer buffer, String splitConfig) throws IOException // this is where checked exceptions piss me off. this method only uses
// a StringReader which can never throw an exception...
{
    if (buffer != null) {
        return editPane = createEditPane(buffer);
    } else if (splitConfig == null || splitConfig.trim().length() == 0) {
        Buffer buf = jEdit.getFirstBuffer();
        if (buf == null) {
            buf = BufferSetManager.createUntitledBuffer();
        }
        return editPane = createEditPane(buf);
    }
    Buffer[] buffers = jEdit.getBuffers();
    Stack<Object> stack = new Stack<Object>();
    // we create a stream tokenizer for parsing a simple
    // stack-based language
    StreamTokenizer st = new StreamTokenizer(new StringReader(splitConfig));
    st.whitespaceChars(0, ' ');
    /* all printable ASCII characters */
    st.wordChars('#', '~');
    st.commentChar('!');
    st.quoteChar('"');
    st.eolIsSignificant(false);
    List<Buffer> editPaneBuffers = new ArrayList<Buffer>();
    loop: while (true) {
        switch(st.nextToken()) {
            case StreamTokenizer.TT_EOF:
                break loop;
            case StreamTokenizer.TT_WORD:
                if ("vertical".equals(st.sval) || "horizontal".equals(st.sval)) {
                    int orientation = "vertical".equals(st.sval) ? JSplitPane.VERTICAL_SPLIT : JSplitPane.HORIZONTAL_SPLIT;
                    int divider = (Integer) stack.pop();
                    Object obj1 = stack.pop();
                    Object obj2 = stack.pop();
                    // Backward compatibility with pre-bufferset versions
                    if (obj1 instanceof Buffer) {
                        Buffer b1 = buffer = (Buffer) obj1;
                        obj1 = editPane = createEditPane(b1);
                    }
                    if (obj2 instanceof Buffer) {
                        Buffer b2 = (Buffer) obj2;
                        obj2 = createEditPane(b2);
                    }
                    stack.push(splitPane = new JSplitPane(orientation, (Component) obj1, (Component) obj2));
                    splitPane.setOneTouchExpandable(true);
                    splitPane.setBorder(null);
                    splitPane.setMinimumSize(new Dimension(0, 0));
                    splitPane.setDividerLocation(divider);
                } else if ("buffer".equals(st.sval)) {
                    Object obj = stack.pop();
                    if (obj instanceof Integer) {
                        int index = (Integer) obj;
                        if (index >= 0 && index < buffers.length)
                            buffer = buffers[index];
                    } else if (obj instanceof String) {
                        String path = (String) obj;
                        buffer = jEdit.getBuffer(path);
                        if (buffer == null) {
                            buffer = jEdit.openTemporary(jEdit.getActiveView(), null, path, true, null, true);
                            jEdit.commitTemporary(buffer);
                        }
                    }
                    if (buffer == null)
                        buffer = jEdit.getFirstBuffer();
                    stack.push(buffer);
                    editPaneBuffers.add(buffer);
                } else if ("buff".equals(st.sval)) {
                    String path = (String) stack.pop();
                    buffer = jEdit.getBuffer(path);
                    if (buffer == null) {
                        Log.log(Log.WARNING, this, "Buffer " + path + " doesn't exist");
                    } else {
                        editPaneBuffers.add(buffer);
                    }
                } else if ("bufferset".equals(st.sval)) {
                    // pop the bufferset scope. Not used anymore but still here for compatibility
                    // with old perspectives
                    stack.pop();
                    buffer = (Buffer) stack.pop();
                    editPane = createEditPane(buffer);
                    stack.push(editPane);
                    BufferSet bufferSet = editPane.getBufferSet();
                    int i = 0;
                    for (Buffer buff : editPaneBuffers) {
                        bufferSet.addBufferAt(buff, i);
                        i++;
                    }
                    editPaneBuffers.clear();
                }
                break;
            case StreamTokenizer.TT_NUMBER:
                stack.push((int) st.nval);
                break;
            case '"':
                stack.push(st.sval);
                break;
        }
    }
    // Backward compatibility with pre-bufferset versions
    Object obj = stack.peek();
    if (obj instanceof Buffer) {
        obj = editPane = createEditPane((Buffer) obj);
    }
    updateGutterBorders();
    return (Component) obj;
}