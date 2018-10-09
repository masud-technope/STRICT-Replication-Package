//}}}
//{{{ removeViewFromList() method
private static void removeViewFromList(View view) {
    viewCount--;
    if (viewsFirst == viewsLast) {
        viewsFirst = viewsLast = null;
        return;
    }
    if (view == viewsFirst) {
        viewsFirst = view.next;
        view.next.prev = null;
    } else {
        view.prev.next = view.next;
    }
    if (view == viewsLast) {
        viewsLast = viewsLast.prev;
        view.prev.next = null;
    } else {
        view.next.prev = view.prev;
    }
}