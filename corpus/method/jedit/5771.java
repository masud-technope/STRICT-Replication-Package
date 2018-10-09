 PluginList(Task task) {
    id = jEdit.getProperty("plugin-manager.mirror.id");
    this.task = task;
    readPluginList(true);
}