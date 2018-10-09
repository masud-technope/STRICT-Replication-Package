//}}}
//{{{ updateTasksCount() method
private void updateTasksCount() {
    remainingCount.setText(jEdit.getProperty("taskmanager.remainingtasks.label", new Object[] { model.getRowCount() }));
}