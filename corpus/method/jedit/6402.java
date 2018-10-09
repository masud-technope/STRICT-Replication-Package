//}}}
//{{{ parse()
/**
	 * Parses the given split configuration string and removes splits, file names,
	 * and remote file names bases on the settings for this parser.
	 * @return The split configuration string adjusted for user preferences.
	 */
public String parse() {
    if (splitConfig == null || splitConfig.length() == 0) {
        return "";
    }
    Deque<Object> tokenStack = new ArrayDeque<Object>();
    Deque<Object> splitStack = new ArrayDeque<Object>();
    BufferSet bufferset = new BufferSet(includeFiles, includeRemotes);
    boolean haveSplit = false;
    try {
        StreamTokenizer st = new StreamTokenizer(new StringReader(splitConfig));
        st.whitespaceChars(0, ' ');
        st.wordChars('#', '~');
        st.commentChar('!');
        st.quoteChar('"');
        st.eolIsSignificant(false);
        int token = st.nextToken();
        while (token != StreamTokenizer.TT_EOF) {
            switch(token) {
                case StreamTokenizer.TT_WORD:
                    if ("vertical".equals(st.sval) || "horizontal".equals(st.sval)) {
                        // the first 2 items in the split stack.
                        if (includeSplits) {
                            Object right = splitStack.pop();
                            Object left = splitStack.pop();
                            Split split = new Split();
                            split.setLeft(left);
                            split.setRight(right);
                            split.setDirection(st.sval);
                            int offset = (Integer) tokenStack.pop();
                            split.setOffset(offset);
                            splitStack.push(split);
                            haveSplit = true;
                        }
                    } else if ("buffer".equals(st.sval) || "buff".equals(st.sval)) {
                        // add to buffer set
                        Object filename = tokenStack.pop();
                        bufferset.addBuffer(filename.toString());
                    } else if ("bufferset".equals(st.sval)) {
                        // close out current buffer set, push to split stack,
                        // create new buffer set.
                        Object scope = tokenStack.pop();
                        bufferset.setScope(scope.toString());
                        splitStack.push(bufferset);
                        bufferset = new BufferSet(includeFiles, includeRemotes);
                    }
                    break;
                case StreamTokenizer.TT_NUMBER:
                    tokenStack.push((int) st.nval);
                    break;
                case '"':
                    tokenStack.push(st.sval);
                    break;
            }
            token = st.nextToken();
        }
        StringBuilder sb = new StringBuilder();
        // BufferSets to a single BufferSet.
        if (haveSplit) {
            while (!splitStack.isEmpty()) {
                sb.append(splitStack.pop().toString()).append(' ');
            }
        } else {
            // no splits, only buffersets
            BufferSet allBuffers = new BufferSet();
            while (!splitStack.isEmpty()) {
                BufferSet bs = (BufferSet) splitStack.pop();
                if (allBuffers.getScope() == null) {
                    allBuffers.setScope(bs.getScope());
                }
                allBuffers.addBufferSet(bs);
            }
            sb.append(allBuffers.toString());
        }
        // don't get unescaped prematurely
        return sb.toString().replaceAll("\\\\", "\\\\\\\\").trim();
    } catch (IOException e) {
    }
    return splitConfig;
}