//}}}
//{{{ getStyle() method
public SyntaxStyle getStyle() {
    if (!okClicked)
        return null;
    Color foreground = (fgColorCheckBox.isSelected() ? fgColor.getSelectedColor() : null);
    Color background = (bgColorCheckBox.isSelected() ? bgColor.getSelectedColor() : null);
    Font font = new JLabel().getFont();
    return new SyntaxStyle(foreground, background, new Font(font.getFamily(), (italics.isSelected() ? Font.ITALIC : 0) | (bold.isSelected() ? Font.BOLD : 0), font.getSize()));
}