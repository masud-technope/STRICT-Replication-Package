//}}}
//{{{ drop() method
public void drop(DropTargetDropEvent dtde) {
    Log.log(Log.DEBUG, this, "Drop");
    //textArea.getBuffer().endCompoundEdit();
    savedBuffer = null;
}