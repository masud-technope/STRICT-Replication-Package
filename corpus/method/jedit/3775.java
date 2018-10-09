//}}}
//{{{ addNotify() method
public void addNotify() {
    super.addNotify();
    EditBus.addToBus(this);
}