//}}}
//{{{ handleEditPaneUpdate() method
@EBHandler
public void handleEditPaneUpdate(EditPaneUpdate epu) {
    if (epu.getEditPane().getView().equals(view) && epu.getWhat().equals(EditPaneUpdate.BUFFER_CHANGED)) {
        refreshList();
    }
}