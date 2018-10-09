//}}}
//{{{ removeNotify() method
@Override
public void removeNotify() {
    super.removeNotify();
    EditBus.removeFromBus(this);
}