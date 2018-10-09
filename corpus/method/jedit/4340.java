//}}}
//{{{ setCurrentScrollPosition() method
public void setCurrentScrollPosition(URL currentPage, int scrollPosition) {
    if ((null != currentPage) && (historyPos >= 1) && (currentPage.toString().equals(history[historyPos - 1].url))) {
        history[historyPos - 1].scrollPosition = scrollPosition;
    }
}