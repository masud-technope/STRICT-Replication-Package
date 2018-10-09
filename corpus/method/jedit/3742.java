//}}}
//{{{ addNotify() method
@Override
public void addNotify() {
    super.addNotify();
    cellRenderer.updateColors(list);
    ListModel model = Log.getLogListModel();
    model.addListDataListener(listModel);
    model.addListDataListener(listHandler = new ListHandler());
    if (tailIsOn)
        scrollToTail();
    EditBus.addToBus(this);
}