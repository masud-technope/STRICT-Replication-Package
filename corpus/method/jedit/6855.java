//}}}
//{{{ dispose() method
@Override
public void dispose() {
    EditBus.removeFromBus(this);
    super.dispose();
}