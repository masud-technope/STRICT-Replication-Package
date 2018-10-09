//}}}
//{{{ setTransferHandler() method
@Override
public void setTransferHandler(TransferHandler newHandler) {
    super.setTransferHandler(newHandler);
    try {
        getDropTarget().addDropTargetListener(new TextAreaDropHandler(this));
    } catch (TooManyListenersException e) {
        Log.log(Log.ERROR, this, e);
    }
}