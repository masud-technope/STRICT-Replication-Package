//}}}
//{{{ removeNotify() method
public void removeNotify() {
    super.removeNotify();
    EditBus.removeFromBus(this);
}