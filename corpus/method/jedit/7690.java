@Override
public final void setValue(long value) {
    this.value = value;
    TaskManager.instance.fireValueUpdated(this);
}