private JPanel createDockingFrameworkChooser() {
    String[] frameworks = ServiceManager.getServiceNames(View.DOCKING_FRAMEWORK_PROVIDER_SERVICE);
    dockingFramework = new JComboBox<String>(frameworks);
    String framework = View.getDockingFrameworkName();
    for (int i = 0; i < frameworks.length; i++) {
        if (frameworks[i].equals(framework)) {
            dockingFramework.setSelectedIndex(i);
            break;
        }
    }
    dockingFramework.setToolTipText(jEdit.getProperty("options.docking.system-change.note"));
    JPanel p = new JPanel();
    p.setToolTipText(jEdit.getProperty("options.docking.system-change.note"));
    p.setLayout(new FlowLayout());
    p.add(new JLabel(jEdit.getProperty("options.docking.selectFramework.label")));
    p.add(dockingFramework);
    return p;
}