//}}}
//{{{ setLeftTitle() method
public void setLeftTitle(String leftTitle) {
    if (leftTitle == null) {
        removeLeftTitle();
        return;
    }
    if (leftLabel == null) {
        leftLabel = new JLabel();
    }
    leftLabel.setText(leftTitle);
    leftPanel.add(leftLabel, BorderLayout.NORTH);
}