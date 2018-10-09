//}}}
//{{{ removeRightTitle() method
public void removeRightTitle() {
    if (rightLabel != null) {
        rightPanel.remove(rightLabel);
        rightLabel = null;
    }
}