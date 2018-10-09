//}}}
//{{{ cancel() method
@Override
public void cancel() {
    EditBus.send(new PropertiesChanging(null, PropertiesChanging.State.CANCELED));
    super.cancel();
}