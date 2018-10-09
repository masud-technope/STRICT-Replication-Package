//}}}
//{{{ dispose() method
@Override
public void dispose() {
    EditBus.removeFromBus(this);
    jEdit.setIntegerProperty("helpviewer.splitter", splitter.getDividerLocation());
    super.dispose();
}