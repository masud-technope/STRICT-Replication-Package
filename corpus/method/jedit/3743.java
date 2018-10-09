//}}}
//{{{ scrollToTail() method
/** Scroll to the tail of the logs. */
private void scrollToTail() {
    int index = list.getModel().getSize();
    if (index != 0)
        list.ensureIndexIsVisible(index - 1);
}