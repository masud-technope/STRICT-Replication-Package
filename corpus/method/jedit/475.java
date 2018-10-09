 ChooseDirectory() {
    super(new BorderLayout());
    osTaskDirs = new HashMap();
    JPanel directoryPanel = new JPanel(new GridBagLayout());
    installDir = addField(directoryPanel, "Install program in:", OperatingSystem.getOperatingSystem().getInstallDirectory(appName, appVersion));
    installDir.addFocusListener(new FocusAdapter() {

        public void focusLost(FocusEvent fe) {
            nextButton.setEnabled(isOK());
        }
    });
    for (int i = 0; i < osTasks.length; i++) {
        OperatingSystem.OSTask osTask = osTasks[i];
        String label = osTask.getLabel();
        if (label != null) {
            JTextField field = addField(directoryPanel, label, osTask.getDirectory());
            osTaskDirs.put(osTask, field);
        }
    }
    ChooseDirectory.this.add(BorderLayout.NORTH, directoryPanel);
}