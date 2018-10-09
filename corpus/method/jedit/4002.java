//{{{ addNotify() method
@Override
public void addNotify() {
    super.addNotify();
    update();
    int millisecondsPerMinute = 1000 * 60;
    timer = new Timer(millisecondsPerMinute, this);
    timer.setInitialDelay((int) (millisecondsPerMinute - System.currentTimeMillis() % millisecondsPerMinute) + 500);
    timer.start();
    ToolTipManager.sharedInstance().registerComponent(this);
//}}}
}