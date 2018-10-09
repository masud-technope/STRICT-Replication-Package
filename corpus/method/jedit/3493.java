//}}}
//{{{ addComponentsToPane() method
public void addComponentsToPane() {
    JPanel content = new JPanel(new BorderLayout());
    content.setBorder(BorderFactory.createEmptyBorder(12, 12, 11, 11));
    setContentPane(content);
    if (selectedFiles.length == 1) {
        content.add(BorderLayout.NORTH, createNorthPanel());
        content.add(BorderLayout.CENTER, createCenterPanel());
    } else if (selectedFiles.length > 1) {
        content.add(BorderLayout.NORTH, createNorthPanelAll());
        content.add(BorderLayout.CENTER, createCenterPanelAll());
    }
    content.add(BorderLayout.SOUTH, createSouthPanel());
}