//{{{ createAndShowGUI() method
private void createAndShowGUI() {
    addComponentsToPane();
    pack();
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setFocusable(true);
    toFront();
    requestFocus();
    setResizable(false);
    setVisible(true);
}