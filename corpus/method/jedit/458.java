private JPanel createCompPanel() {
    filesets = new Vector();
    int count = installer.getIntegerProperty("comp.count");
    JPanel panel = new JPanel(new GridLayout(count, 1));
    String osClass = OperatingSystem.getOperatingSystem().getClass().getName();
    osClass = osClass.substring(osClass.indexOf('$') + 1);
    for (int i = 0; i < count; i++) {
        String os = installer.getProperty("comp." + i + ".os");
        if (os != null && !osClass.equals(os))
            continue;
        JCheckBox checkBox = new JCheckBox(installer.getProperty("comp." + i + ".name") + " (" + installer.getProperty("comp." + i + ".disk-size") + "Kb)");
        checkBox.getModel().setSelected(true);
        checkBox.addActionListener(this);
        checkBox.setRequestFocusEnabled(false);
        filesets.addElement(new Integer(i));
        panel.add(checkBox);
    }
    Dimension dim = panel.getPreferredSize();
    dim.width = Integer.MAX_VALUE;
    panel.setMaximumSize(dim);
    return panel;
}