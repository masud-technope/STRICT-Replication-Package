//}}}
//{{{ getSelectedFont() method
public Font getSelectedFont() {
    if (!isOK)
        return null;
    int size;
    try {
        size = Integer.parseInt(sizeField.getText());
    } catch (Exception e) {
        size = 12;
    }
    return new Font(familyField.getText(), styleList.getSelectedIndex(), size);
}