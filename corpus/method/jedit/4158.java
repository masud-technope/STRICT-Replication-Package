//}}}
//{{{ addNotify() method
@Override
public void addNotify() {
    TaskManager.instance.visit(new TaskManager.TaskVisitor() {

        public void visit(Task task) {
            model.addTask(task);
        }
    });
    TaskManager.instance.addTaskListener(this);
    super.addNotify();
}