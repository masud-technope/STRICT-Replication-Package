//}}}
//{{{ addNotify() method
@Override
public void addNotify() {
    super.addNotify();
    TaskManager.instance.addTaskListener(taskHandler);
}