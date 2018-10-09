//}}}
//{{{ performOperationsInWorkThread() method
void performOperationsInWorkThread(PluginManagerProgress progress) {
    for (Operation op : operations) {
        op.runInWorkThread(progress);
        progress.done();
        if (Thread.interrupted())
            return;
    }
}