//}}}
//{{{ handleViewUpdate() method
@EBHandler
public void handleViewUpdate(ViewUpdate vu) {
    if (vu.getView().equals(view) && vu.getWhat().equals(ViewUpdate.EDIT_PANE_CHANGED)) {
        refreshList();
    }
}