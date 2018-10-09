@Override
public void removeNotify() {
    super.removeNotify();
    TaskManager.instance.removeTaskListener(this);
}