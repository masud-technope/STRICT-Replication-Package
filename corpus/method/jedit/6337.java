//}}}
//{{{ dispose() method
@Override
public void dispose() {
    EditBus.removeFromBus(this);
    viewHash.remove(view);
    super.dispose();
}