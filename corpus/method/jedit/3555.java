//}}}
//{{{ dispose() method
@Override
public void dispose() {
    entry.container = null;
    entry.win = null;
    super.dispose();
}