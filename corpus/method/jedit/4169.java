//{{{ addTask() method
void addTask(final Task task) {
    ThreadUtilities.runInDispatchThread(new Runnable() {

        public void run() {
            tasks.add(task);
            fireTableRowsInserted(tasks.size() - 1, tasks.size() - 1);
        }
    });
//}}}
}