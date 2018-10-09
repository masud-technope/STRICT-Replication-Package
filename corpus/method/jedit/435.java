public  OSTask(Install installer, String name) {
    this.installer = installer;
    this.name = name;
    this.label = installer.getProperty("ostask." + name + ".label");
    this.directory = getDefaultDirectory(installer);
    // on by default
    enabled = true;
}