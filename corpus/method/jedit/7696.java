@Override
public final void setMaximum(long maximum) {
    this.maximum = maximum;
    TaskManager.instance.fireMaximumUpdated(this);
}