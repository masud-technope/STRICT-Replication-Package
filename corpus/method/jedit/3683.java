//}}}
//{{{ invokeReadNextChar() method
protected void invokeReadNextChar(char ch) {
    JEditBuffer buffer = view.getBuffer();
    /* if(buffer.insideCompoundEdit())
			buffer.endCompoundEdit(); */
    String charStr = StandardUtilities.charsToEscapes(String.valueOf(ch));
    // this might be a bit slow if __char__ occurs a lot
    int index;
    while ((index = readNextChar.indexOf("__char__")) != -1) {
        readNextChar = readNextChar.substring(0, index) + '\'' + charStr + '\'' + readNextChar.substring(index + 8);
    }
    Macros.Recorder recorder = view.getMacroRecorder();
    if (recorder != null)
        recorder.record(getRepeatCount(), readNextChar);
    view.getStatus().setMessage(null);
    if (getRepeatCount() != 1) {
        try {
            buffer.beginCompoundEdit();
            BeanShell.eval(view, BeanShell.getNameSpace(), "for(int i = 1; i < " + getRepeatCount() + "; i++)\n{\n" + readNextChar + "\n}");
        } finally {
            buffer.endCompoundEdit();
        }
    } else
        BeanShell.eval(view, BeanShell.getNameSpace(), readNextChar);
    readNextChar = null;
}