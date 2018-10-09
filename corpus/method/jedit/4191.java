public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == showNextTime) {
        jEdit.setBooleanProperty("tip.show", showNextTime.isSelected());
    } else if (source == nextTip)
        nextTip();
    else if (source == close)
        dispose();
}