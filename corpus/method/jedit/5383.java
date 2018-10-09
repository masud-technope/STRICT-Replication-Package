//}}}
//{{{ init() method
@Override
protected void init(String name, String pane) {
    EditBus.send(new PropertiesChanging(null, PropertiesChanging.State.LOADING));
    super.init(name, pane);
}