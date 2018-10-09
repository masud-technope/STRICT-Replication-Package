@Override
public void done(Task task) {
    if (task == AbstractBrowserTask.this) {
        TaskManager.instance.removeTaskListener(this);
        ThreadUtilities.runInDispatchThread(runnable);
    }
}