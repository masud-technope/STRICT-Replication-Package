//}}}
//{{{ dragExit() method
@Override
public void dragExit(DropTargetEvent dtde) {
    Log.log(Log.DEBUG, this, "Drag exit");
    //textArea.getBuffer().endCompoundEdit();
    if (textArea.getBuffer() == savedBuffer) {
        textArea.moveCaretPosition(savedCaret, TextArea.ELECTRIC_SCROLL);
    }
    savedBuffer = null;
}