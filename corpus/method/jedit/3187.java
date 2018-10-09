//}}}
//{{{ moveRelative method()
private void moveRelative(int n) {
    int selected = list.getSelectedIndex();
    int newSelect = selected + n;
    if (newSelect < 0) {
        newSelect = 0;
    } else {
        int numItems = list.getModel().getSize();
        if (numItems < 1) {
            return;
        }
        if (newSelect >= numItems) {
            newSelect = numItems - 1;
        }
    }
    if (newSelect != selected) {
        setSelectedIndex(newSelect);
    }
}