//}}}
//{{{ addViewToList() method
private static void addViewToList(View view) {
    viewCount++;
    if (viewsFirst == null)
        viewsFirst = viewsLast = view;
    else {
        view.prev = viewsLast;
        viewsLast.next = view;
        viewsLast = view;
    }
}