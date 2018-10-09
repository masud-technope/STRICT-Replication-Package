//}}}
//{{{ updatePreview() method
private void updatePreview() {
    String family = familyField.getText();
    int size;
    try {
        size = Integer.parseInt(sizeField.getText());
    } catch (Exception e) {
        size = 12;
    }
    int style = styleList.getSelectedIndex();
    preview.setFont(new Font(family, style, size));
}