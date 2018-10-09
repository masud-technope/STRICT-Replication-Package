//{{{ _add() method
private void _add(Edit edit) {
    if (first == null)
        first = last = edit;
    else {
        edit.prev = last;
        last.next = edit;
        last = edit;
    }
//}}}
}