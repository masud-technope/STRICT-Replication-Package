//}}}
//{{{ removeLeftTitle() method
public void removeLeftTitle() {
    if (leftLabel != null) {
        leftPanel.remove(leftLabel);
        leftLabel = null;
    }
}