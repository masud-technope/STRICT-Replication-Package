//}}}
//{{{ run() method
@Override
public final void run() {
    state = SwingWorker.StateValue.STARTED;
    TaskManager.instance.fireRunning(this);
    try {
        thread = Thread.currentThread();
        _run();
        thread = null;
    } catch (Throwable t) {
        Log.log(Log.ERROR, this, t);
    }
    state = SwingWorker.StateValue.DONE;
    TaskManager.instance.fireDone(this);
}