//}}}
//}}}
//{{{ Buffer creation methods
//{{{ openFiles() method
/**
	 * Opens the file names specified in the argument array. This
	 * handles +line and +marker arguments just like the command
	 * line parser.
	 * @param parent The parent directory
	 * @param args The file names to open
	 * @since jEdit 3.2pre4
	 */
public static Buffer openFiles(View view, String parent, String[] args) {
    Buffer retVal = null;
    Buffer lastBuffer = null;
    for (String arg : args) {
        if (arg == null)
            continue;
        else if (arg.startsWith("+line:") || arg.startsWith("+marker:")) {
            if (lastBuffer != null)
                gotoMarker(view, lastBuffer, arg);
            continue;
        }
        lastBuffer = openFile((View) null, parent, arg, false, null);
        if (retVal == null && lastBuffer != null)
            retVal = lastBuffer;
    }
    if (view != null && retVal != null) {
        if (view.getBuffer() != retVal) {
            view.setBuffer(retVal);
            // caret overhere.
            if (!view.getTextArea().isCaretVisible())
                view.getTextArea().scrollToCaret(false);
        }
    }
    return retVal;
}