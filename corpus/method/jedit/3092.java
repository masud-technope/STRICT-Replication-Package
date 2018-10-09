@Override
public void cancel() {
    canceled = true;
    dispose();
}