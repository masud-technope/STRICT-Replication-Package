//}}}
//{{{ actionPerformed() method
public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == ok)
        ok();
    else if (source == cancel)
        cancel();
    else if (source == fgColorCheckBox)
        fgColor.setEnabled(fgColorCheckBox.isSelected());
    else if (source == bgColorCheckBox)
        bgColor.setEnabled(bgColorCheckBox.isSelected());
}