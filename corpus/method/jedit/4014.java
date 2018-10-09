//{{{ addNotify() method
@Override
public void addNotify() {
    super.addNotify();
    update();
    int millisecondsPerMinute = 1000;
    timer = new Timer(millisecondsPerMinute, this);
    timer.start();
    ToolTipManager.sharedInstance().registerComponent(this);
//}}}
}