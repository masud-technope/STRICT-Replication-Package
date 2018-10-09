//}}}
//{{{ setRightTitle() method
public void setRightTitle(String rightTitle) {
    if (rightTitle == null) {
        removeRightTitle();
        return;
    }
    if (rightLabel == null) {
        rightLabel = new JLabel();
    }
    rightLabel.setText(rightTitle);
    rightPanel.add(rightLabel, BorderLayout.NORTH);
}