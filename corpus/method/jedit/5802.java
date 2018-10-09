//}}}
//{{{ dispose() method
@Override
public void dispose() {
    instance = null;
    EditBus.removeFromBus(this);
    EditBus.removeFromBus(installer);
    super.dispose();
}