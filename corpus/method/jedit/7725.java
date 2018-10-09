private  TaskManager() {
    listeners = new CopyOnWriteArrayList<TaskListener>();
    tasks = Collections.synchronizedList(new ArrayList<Task>());
    ioWaitLock = new Object();
}