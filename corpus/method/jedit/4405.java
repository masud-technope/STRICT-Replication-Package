//}}}
//{{{ historyUpdated() method
@Override
public void historyUpdated() {
    back.setEnabled(historyModel.hasPrevious());
    forward.setEnabled(historyModel.hasNext());
}