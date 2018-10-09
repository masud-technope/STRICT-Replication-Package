@Override
public Thread newThread(Runnable r) {
    return new Thread(r, "SizeSaver-" + executorThreadsCounter.incrementAndGet());
}