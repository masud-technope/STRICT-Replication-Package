protected void prepareTask(Task task) {
    task.setProject(getProject());
    task.setOwningTarget(getOwningTarget());
    task.setTaskName(getTaskName());
    task.setTaskType(getTaskType());
}