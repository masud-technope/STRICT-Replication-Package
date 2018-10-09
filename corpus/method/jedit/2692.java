//{{{ exchangeLastElement() method
private void exchangeLastElement(Edit edit) {
    // remove last
    if (first == last)
        first = last = null;
    else {
        last.prev.next = null;
        last = last.prev;
    }
    // exchange current last
    if (first == null || first == last)
        first = last = edit;
    else {
        edit.prev = last.prev;
        last.prev.next = edit;
        last = edit;
    }
//}}}
}