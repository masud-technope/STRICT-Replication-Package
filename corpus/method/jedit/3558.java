public void actionPerformed(ActionEvent evt) {
    Font font;
    JDialog dialog = GenericGUIUtilities.getParentDialog(FontSelector.this);
    if (dialog == null) {
        font = new FontSelectorDialog(JOptionPane.getFrameForComponent(FontSelector.this), getFont(), FontSelector.this).getSelectedFont();
    } else {
        font = new FontSelectorDialog(dialog, getFont(), FontSelector.this).getSelectedFont();
    }
    if (font != null) {
        setFont(font);
        updateText();
    }
}