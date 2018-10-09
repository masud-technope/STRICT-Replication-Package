void install() {
    Vector components = new Vector();
    int size = 0;
    JPanel comp = selectComponents.comp;
    Vector ids = selectComponents.filesets;
    for (int i = 0; i < comp.getComponentCount(); i++) {
        if (((JCheckBox) comp.getComponent(i)).getModel().isSelected()) {
            size += installer.getIntegerProperty("comp." + ids.elementAt(i) + ".real-size");
            components.addElement(installer.getProperty("comp." + ids.elementAt(i) + ".fileset"));
        }
    }
    String installDir = chooseDirectory.installDir.getText();
    Map osTaskDirs = chooseDirectory.osTaskDirs;
    Iterator keys = osTaskDirs.keySet().iterator();
    while (keys.hasNext()) {
        OperatingSystem.OSTask osTask = (OperatingSystem.OSTask) keys.next();
        String dir = ((JTextField) osTaskDirs.get(osTask)).getText();
        if (dir != null && dir.trim().length() != 0) {
            osTask.setEnabled(true);
            osTask.setDirectory(dir);
        } else
            osTask.setEnabled(false);
    }
    InstallThread thread = new InstallThread(installer, progress, installDir, osTasks, size, components);
    progress.setThread(thread);
    thread.start();
}