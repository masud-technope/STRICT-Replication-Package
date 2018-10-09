public void valueChanged(ListSelectionEvent evt) {
    Object source = evt.getSource();
    if (source == familyList) {
        String family = (String) familyList.getSelectedValue();
        if (family != null)
            familyField.setText(family);
    } else if (source == sizeList) {
        String size = (String) sizeList.getSelectedValue();
        if (size != null)
            sizeField.setText(size);
    } else if (source == styleList) {
        String style = (String) styleList.getSelectedValue();
        if (style != null)
            styleField.setText(style);
    }
    updatePreview();
}