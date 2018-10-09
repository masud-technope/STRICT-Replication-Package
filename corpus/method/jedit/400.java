public  InstallThread(Install installer, Progress progress, String installDir, OperatingSystem.OSTask[] osTasks, int size, Vector components) {
    super("Install thread");
    this.installer = installer;
    this.progress = progress;
    this.installDir = installDir;
    this.osTasks = osTasks;
    this.size = size;
    this.components = components;
}