//}}}
//{{{ addNotify() method
@Override
public void addNotify() {
    super.addNotify();
    EditBus.addToBus(this);
    multiStatus = jEdit.getBooleanProperty("hypersearch-results.multi");
    updateHighlightStatus();
    updateMultiStatus();
}