@Override
public void addNotify() {
    super.addNotify();
    TaskManager.instance.addTaskListener(this);
    update();
}