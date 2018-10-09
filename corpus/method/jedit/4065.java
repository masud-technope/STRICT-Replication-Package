//{{{ addNotify() method
@Override
public void addNotify() {
    super.addNotify();
    timer = new Timer(2000, this);
    timer.start();
    ToolTipManager.sharedInstance().registerComponent(this);
//}}}
}