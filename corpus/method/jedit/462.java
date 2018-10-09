private void updateSize() {
    int size = 0;
    for (int i = 0; i < filesets.size(); i++) {
        if (((JCheckBox) comp.getComponent(i)).getModel().isSelected()) {
            size += installer.getIntegerProperty("comp." + filesets.elementAt(i) + ".disk-size");
        }
    }
    sizeLabel.setText("Estimated disk usage of selected" + " components: " + size + "Kb");
}