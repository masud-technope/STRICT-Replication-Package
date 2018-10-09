//}}}
//{{{ removeNotify() method
@Override
public void removeNotify() {
    super.removeNotify();
    EditBus.removeFromBus(this);
    jEdit.setBooleanProperty("hypersearch-results.multi", multiStatus);
}