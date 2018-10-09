public void actionPerformed(ActionEvent evt) {
    JDialog parent = GenericGUIUtilities.getParentDialog(ColorWellButton.this);
    Color c = null;
    if (parent != null) {
        ColorChooserDialog dialog = new ColorChooserDialog(parent, getSelectedColor());
        c = dialog.getColor();
    } else {
        ColorChooserDialog dialog = new ColorChooserDialog((Window) SwingUtilities.getRoot(ColorWellButton.this), getSelectedColor());
        c = dialog.getColor();
    }
    if (c != null) {
        setSelectedColor(c);
    }
}