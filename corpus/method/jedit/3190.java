//}}}
//{{{ moveRelativePages() method
private void moveRelativePages(int n) {
    int pageSize = list.getVisibleRowCount() - 1;
    moveRelative(pageSize * n);
}