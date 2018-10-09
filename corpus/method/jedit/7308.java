//}}}
//{{{ dragEnter() method
@Override
public void dragEnter(DropTargetDragEvent dtde) {
    Log.log(Log.DEBUG, this, "Drag enter");
    savedBuffer = textArea.getBuffer();
    //textArea.getBuffer().beginCompoundEdit();
    savedCaret = textArea.getCaretPosition();
}