private  JEditThreadFactory() {
    threadIDs = new AtomicInteger(0);
    threadGroup = new ThreadGroup("jEdit Workers");
}