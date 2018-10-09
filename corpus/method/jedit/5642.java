 Entry(PluginList.Plugin plugin, String set) {
    PluginList.Branch branch = plugin.getCompatibleBranch();
    boolean downloadSource = jEdit.getBooleanProperty("plugin-manager.downloadSource");
    int size = downloadSource ? branch.downloadSourceSize : branch.downloadSize;
    this.name = plugin.name;
    this.author = plugin.author;
    this.installedVersion = plugin.getInstalledVersion();
    this.version = branch.version;
    this.size = size;
    this.date = branch.date;
    this.description = plugin.description;
    this.dependencies = branch.depsToString();
    this.set = set;
    this.install = false;
    this.checked = false;
    this.plugin = plugin;
    SimpleDateFormat format = new SimpleDateFormat("d MMMM yyyy", Locale.ENGLISH);
    try {
        timestamp = format.parse(date).getTime();
    } catch (ParseException e) {
        Log.log(Log.ERROR, this, e);
    }
}