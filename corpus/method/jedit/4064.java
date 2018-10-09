//{{{ removeNotify() method
@Override
public void removeNotify() {
    timer.stop();
    ToolTipManager.sharedInstance().unregisterComponent(this);
    super.removeNotify();
//}}}
}