//}}}
//{{{ removeNotify() method
@Override
public void removeNotify() {
    TaskManager.instance.removeTaskListener(this);
    super.removeNotify();
    model.removeAll();
}