//}}}
//{{{ Protected members
//{{{ _init() method
@Override
protected void _init() {
    setLayout(new BorderLayout(6, 6));
    add(BorderLayout.CENTER, createStyleTableScroller());
}