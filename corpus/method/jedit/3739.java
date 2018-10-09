//}}}
//{{{ removeNotify() method
@Override
public void removeNotify() {
    super.removeNotify();
    ListModel model = Log.getLogListModel();
    model.removeListDataListener(listModel);
    model.removeListDataListener(listHandler);
    listHandler = null;
    EditBus.removeFromBus(this);
}