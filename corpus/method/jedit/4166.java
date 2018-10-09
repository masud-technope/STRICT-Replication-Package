//{{{ removeTask() method
void removeTask(final Task task) {
    ThreadUtilities.runInDispatchThread(new Runnable() {

        public void run() {
            int index = tasks.indexOf(task);
            if (index != -1) {
                tasks.remove(index);
                fireTableRowsDeleted(index, index);
            }
        }
    });
//}}}
}