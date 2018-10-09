@Override
public Thread newThread(Runnable r) {
    Thread t = new Thread(threadGroup, r);
    t.setName("jEdit Worker #" + threadIDs.getAndIncrement());
    return t;
}