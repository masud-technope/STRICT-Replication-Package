@Override
public void setStatus(String status) {
    this.status = status;
    TaskManager.instance.fireStatusUpdated(this);
}