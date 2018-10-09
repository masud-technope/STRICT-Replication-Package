//}}}
//{{{ setVisible() method
@Override
public void setVisible(boolean b) {
    super.setVisible(b);
    if (!b && Debug.DISABLE_SEARCH_DIALOG_POOL) {
        dispose();
    }
}